package com.wonderland.sgl.service;

import com.wonderland.sgl.dto.InsumoCalculadoDTO;
import com.wonderland.sgl.dto.StaffRequeridoDTO;
import com.wonderland.sgl.model.*;
import com.wonderland.sgl.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CalculadoraLogisticaService {

    @Autowired private MenuPlatoRepository menuPlatoRepo;
    @Autowired private MenuBebidaRepository menuBebidaRepo;
    @Autowired private MenuPostreRepository menuPostreRepo;
    @Autowired private RecetaPlatoRepository recetaPlatoRepo;
    @Autowired private RecetaBebidaRepository recetaBebidaRepo;
    @Autowired private RecetaPostreRepository recetaPostreRepo;
    
    @Autowired private MenuPersonajeRepository menuPersonajeRepo;

    public List<InsumoCalculadoDTO> calcularInsumosParaEvento(Integer idMenu, Integer cantNinos) {
        Map<String, InsumoCalculadoDTO> mapaInsumos = new HashMap<>();

        List<MenuPlato> platosDelMenu = menuPlatoRepo.findByMenuIdMenu(idMenu);
        for (MenuPlato mp : platosDelMenu) {
            int totalPlatos = mp.getCantPorNino() * cantNinos;
            List<RecetaPlato> recetas = recetaPlatoRepo.findByPlatoIdPlato(mp.getPlato().getIdPlato());
            for (RecetaPlato rp : recetas) {
                agregarAMapa(mapaInsumos, rp.getInsumo(), rp.getCantidadNecesaria(), totalPlatos);
            }
        }

        List<MenuBebida> bebidasDelMenu = menuBebidaRepo.findByMenuIdMenu(idMenu);
        for (MenuBebida mb : bebidasDelMenu) {
            int totalBebidas = mb.getCantPorNino() * cantNinos;
            List<RecetaBebida> recetas = recetaBebidaRepo.findByBebidaIdBebida(mb.getBebida().getIdBebida());
            for (RecetaBebida rb : recetas) {
                agregarAMapa(mapaInsumos, rb.getInsumo(), rb.getCantidadNecesaria(), totalBebidas);
            }
        }

        List<MenuPostre> postresDelMenu = menuPostreRepo.findByMenuIdMenu(idMenu);
        for (MenuPostre mpo : postresDelMenu) {
            int totalPostres = mpo.getCantPorNino() * cantNinos;
            List<RecetaPostre> recetas = recetaPostreRepo.findByPostreIdPostre(mpo.getPostre().getIdPostre());
            for (RecetaPostre rp : recetas) {
                agregarAMapa(mapaInsumos, rp.getInsumo(), rp.getCantidadNecesaria(), totalPostres);
            }
        }

        return new ArrayList<>(mapaInsumos.values());
    }

    private void agregarAMapa(Map<String, InsumoCalculadoDTO> mapa, Insumo insumo, BigDecimal cantReceta, int totalItems) {
        String clave = insumo.getNombre();
        BigDecimal subtotal = cantReceta.multiply(new BigDecimal(totalItems));

        if (mapa.containsKey(clave)) {
            InsumoCalculadoDTO dtoExistente = mapa.get(clave);
            dtoExistente.setCantidadTotal(dtoExistente.getCantidadTotal().add(subtotal));
        } else {
            mapa.put(clave, new InsumoCalculadoDTO(clave, insumo.getUnidadMedida(), subtotal));
        }
    }

    public List<StaffRequeridoDTO> calcularStaffParaEvento(Integer idMenu, Integer cantNinos) {
        List<StaffRequeridoDTO> staff = new ArrayList<>();

        int cantAnimadores = (int) Math.ceil(cantNinos / 15.0);
        staff.add(new StaffRequeridoDTO("Animador", cantAnimadores));

        int cantGarzones = (int) Math.ceil(cantNinos / 10.0);
        staff.add(new StaffRequeridoDTO("Garzon", cantGarzones));

        staff.add(new StaffRequeridoDTO("Cocinero", 1));

        List<MenuPersonaje> personajesDelMenu = menuPersonajeRepo.findByMenuIdMenu(idMenu);
        for (MenuPersonaje mp : personajesDelMenu) {
            staff.add(new StaffRequeridoDTO("Actor/Actriz: " + mp.getPersonaje().getNombrePersonaje(), 1));
        }

        return staff;
    }
}