/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Entidad.Cliente;
import Entidad.Login;
import Entidad.Pedido;
import config.Conexion;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
/**
 *
 * @author Programador KS 2
 */

 @Controller
public class Controlador {
     Conexion con = new Conexion();
     JdbcTemplate jdbcTemplate = new JdbcTemplate(con.Conectar());
     ModelAndView mav = new ModelAndView();
     int id;
     String rut;

     //CONTROLADOR INDEX
     @RequestMapping("index.htm")
     public ModelAndView Index() {
         mav.setViewName("index");
         return mav;
     }

     //CONTROLADOR DE INGRESO AL FORMULARIO DE LOGIN
     @RequestMapping(value = "login_admin.htm", method = RequestMethod.GET)
     public ModelAndView LoginAdmin() {
         mav.addObject(new Login());
         mav.setViewName("login_admin");
         return mav;
     }

     //CONTROLADOR DE LOGIN ADMIN     
     @RequestMapping(value = "login_admin.htm", method = RequestMethod.POST)
     public ModelAndView LoginAdmin(Login adm) {
         try {
             String sql = "SELECT num FROM tbl_user WHERE perfil=1 AND usuario=? AND clave=?";

             Integer userId = jdbcTemplate.queryForObject(sql, new Object[]{adm.getRut(), adm.getContrasena()}, Integer.class);

             if (userId > 0) {
                 return new ModelAndView("redirect:/admin_tarea.htm");
             } else {
                 mav.addObject("msg_error", "Error en el login.");
                 return mav;
             }

         } catch (Exception e) {
             return null;
         }

     }

     //CONTROLADOR DE OPCIONES DE ADMINISTRADOR
     @RequestMapping("admin_tarea.htm")
     public ModelAndView AdminTarea() {
         mav.setViewName("admin_tarea");
         return mav;
     }

     //CONTROLADOR DE VER TODOS LOS PEDIDOS
     @RequestMapping("admin_ver_pedidos.htm")
     public ModelAndView AdminVerPedidos() {

         String sql = "select\n"
                 + "p.num as idPedido,\n"
                 + "a.nombre as nombreCliente,\n"
                 + "a.direccion as direcciónCliente, \n"
                 + "a.telefono as telefono,\n"
                 + "p.cantidad as cantidadPAn,\n"
                 + "t.nombre as tipoPan,\n"
                 + "p.fecha_pedido as fecha_pedido,\n"
                 + "p.fecha_despacho as fecha_despacho\n"
                 + "from tbl_pedido as p\n"
                 + "join tbl_tipo_pan as t on t.num = p.tipopan\n"
                 + "join tbl_cliente as a on a.num = p.client order by p.num asc";
         List listaDatos = this.jdbcTemplate.queryForList(sql);
         mav.addObject("lista", listaDatos);
         mav.setViewName("admin_ver_pedidos");

         return mav;
     }

     //CONTROLADOR DE ELIMINAR PEDIDO
     @RequestMapping("eliminarPedido.htm")
     public ModelAndView eliminarPedido(HttpServletRequest request) {
         id = Integer.parseInt(request.getParameter("id"));

         String sql = "delete from tbl_pedido where num=" + id;
         this.jdbcTemplate.update(sql);
         return new ModelAndView("redirect:/admin_ver_pedidos.htm");

     }

     //CONTROLADOR LISTAR CLIENTES
     @RequestMapping("admin_lista_cliente.htm")
     public ModelAndView ListarClientes() {
         String sql = "SELECT c.num, c.rut, c.nombre, c.direccion, c.telefono, u.clave FROM `tbl_cliente` as c\n"
                 + "JOIN tbl_user as u ON u.numcliente = c.num where u.perfil= 2 order by c.num ASC";
         List listaClientes = this.jdbcTemplate.queryForList(sql);
         mav.addObject("lista", listaClientes);
         mav.setViewName("admin_lista_cliente");

         return mav;
     }

     //CONTROLADOR DE MOSTRAR FORMULARIO DE AGREGAR CLIENTE
     @RequestMapping(value = "admin_add_cliente.htm", method = RequestMethod.GET)
     public ModelAndView addCliente() {
         mav.addObject(new Cliente());
         mav.setViewName("admin_add_cliente");
         return mav;
     }

     //CONTROLADOR AGREGAR CLIENTE
     @RequestMapping(value = "admin_add_cliente.htm", method = RequestMethod.POST)
     public ModelAndView addCliente(Cliente cl) {

         String sql = "insert into tbl_cliente(rut,nombre,direccion, telefono) values(?,?,?,?)";
         this.jdbcTemplate.update(sql, cl.getRut(), cl.getNombre(), cl.getDireccion(), cl.getTelefono());

         String sql2 = "insert into tbl_user(usuario,clave,perfil,numCliente) "
                 + "values((select rut from tbl_cliente where num = (SELECT MAX(num) FROM tbl_cliente)),"
                 + "?,"
                 + "2,"
                 + "(SELECT MAX(num) FROM tbl_cliente))";
         this.jdbcTemplate.update(sql2, cl.getClave());

         return new ModelAndView("redirect:/admin_lista_cliente.htm");
     }

     //CONTROLADOR DE ELIMINAR Cliente
     @RequestMapping("eliminarCliente.htm")
     public ModelAndView eliminarCliente(HttpServletRequest request) {
         id = Integer.parseInt(request.getParameter("id"));
         String sql = "delete from tbl_cliente where num=" + id;
         this.jdbcTemplate.update(sql);
         String sql2 = "delete from tbl_user where numcliente=" + id;
         this.jdbcTemplate.update(sql2);

         return new ModelAndView("redirect:/admin_lista_cliente.htm");
     }

     //CONTROLADOR DE MOSTRAR FORMULARIO DE EDITAR CLIENTE
     @RequestMapping(value = "admin_edit_cliente.htm", method = RequestMethod.GET)
     public ModelAndView editCliente(HttpServletRequest request) {
         id = Integer.parseInt(request.getParameter("id"));
         String sql = "SELECT c.num, c.rut, c.nombre, c.direccion, c.telefono, u.clave FROM `tbl_cliente` as c "
                 + " JOIN tbl_user as u ON u.numcliente = c.num"
                 + " WHERE c.num=" + id;
         List listaCliente = this.jdbcTemplate.queryForList(sql);
         mav.addObject("lista", listaCliente);
         mav.setViewName("admin_edit_cliente");
         return mav;
     }

     //CONTROLADOR EDITAR CLIENTE
     @RequestMapping(value = "admin_edit_cliente.htm", method = RequestMethod.POST)
     public ModelAndView editCliente(Cliente cl) {
         String sql = "update tbl_cliente set rut=?, nombre=?, direccion=?, telefono=? where num=?";
         this.jdbcTemplate.update(sql, cl.getRut(), cl.getNombre(), cl.getDireccion(), cl.getTelefono(), id);

         String sql2 = "update tbl_user set usuario=?, clave=? where numcliente=?";
         this.jdbcTemplate.update(sql2, cl.getRut(), cl.getClave(), id);

         return new ModelAndView("redirect:/admin_lista_cliente.htm");
     }

     //CONTROLADOR LISTAR VISITA
     @RequestMapping("admin_lista_visita.htm")
     public ModelAndView ListarVisitas() {
         String sql = "SELECT c.num, c.rut, c.nombre, c.direccion, c.telefono, u.clave FROM `tbl_cliente` as c\n"
                 + "JOIN tbl_user as u ON u.numcliente = c.num where u.perfil= 3 order by c.num ASC";
         List listaVisitas = this.jdbcTemplate.queryForList(sql);
         mav.addObject("lista", listaVisitas);
         mav.setViewName("admin_lista_visita");

         return mav;
     }

     //CONTROLADOR DE MOSTRAR FORMULARIO DE AGREGAR VISITA
     @RequestMapping(value = "admin_add_visita.htm", method = RequestMethod.GET)
     public ModelAndView addVisita() {
         mav.addObject(new Cliente());
         mav.setViewName("admin_add_visita");
         return mav;
     }

     //CONTROLADOR AGREGAR VISITA
     @RequestMapping(value = "admin_add_visita.htm", method = RequestMethod.POST)
     public ModelAndView addVisita(Cliente cl) {

         String sql = "insert into tbl_cliente(rut,nombre,direccion, telefono) values(?,?,?,?)";
         this.jdbcTemplate.update(sql, cl.getRut(), cl.getNombre(), cl.getDireccion(), cl.getTelefono());

         String sql2 = "insert into tbl_user(usuario,clave,perfil,numCliente) "
                 + "values((select rut from tbl_cliente where num = (SELECT MAX(num) FROM tbl_cliente)),"
                 + "?,"
                 + "3,"
                 + "(SELECT MAX(num) FROM tbl_cliente))";
         this.jdbcTemplate.update(sql2, cl.getClave());

         return new ModelAndView("redirect:/admin_lista_visita.htm");
     }

     //CONTROLADOR DE ELIMINAR Visita
     @RequestMapping("eliminarVisita.htm")
     public ModelAndView eliminarVisita(HttpServletRequest request) {
         id = Integer.parseInt(request.getParameter("id"));
         String sql = "delete from tbl_cliente where num=" + id;
         this.jdbcTemplate.update(sql);
         String sql2 = "delete from tbl_user where numcliente=" + id;
         this.jdbcTemplate.update(sql2);

         return new ModelAndView("redirect:/admin_lista_visita.htm");
     }

     //CONTROLADOR DE MOSTRAR FORMULARIO DE EDITAR Visita
     @RequestMapping(value = "admin_edit_visita.htm", method = RequestMethod.GET)
     public ModelAndView editVisita(HttpServletRequest request) {
         id = Integer.parseInt(request.getParameter("id"));
         String sql = "SELECT c.num, c.rut, c.nombre, c.direccion, c.telefono, u.clave FROM `tbl_cliente` as c "
                 + " JOIN tbl_user as u ON u.numcliente = c.num"
                 + " WHERE c.num=" + id;
         List listaVisita = this.jdbcTemplate.queryForList(sql);
         mav.addObject("lista", listaVisita);
         mav.setViewName("admin_edit_visita");
         return mav;
     }

     //CONTROLADOR EDITAR VISITA
     @RequestMapping(value = "admin_edit_visita.htm", method = RequestMethod.POST)
     public ModelAndView editVisita(Cliente cl) {
         String sql = "update tbl_cliente set rut=?, nombre=?, direccion=?, telefono=? where num=?";
         this.jdbcTemplate.update(sql, cl.getRut(), cl.getNombre(), cl.getDireccion(), cl.getTelefono(), id);

         String sql2 = "update tbl_user set usuario=?, clave=? where numcliente=?";
         this.jdbcTemplate.update(sql2, cl.getRut(), cl.getClave(), id);

         return new ModelAndView("redirect:/admin_lista_visita.htm");
     }

     //CONTROLADOR DE INGRESO AL FORMULARIO DE LOGIN CLIENTE
     @RequestMapping(value = "login_cliente.htm", method = RequestMethod.GET)
     public ModelAndView LoginCliente() {
         mav.addObject(new Login());
         mav.setViewName("login_cliente");
         return mav;
     }
      
     //CONTROLADOR DE LOGIN CLIENTE     
     @RequestMapping(value = "login_cliente.htm", method = RequestMethod.POST)
     public ModelAndView LoginCliente(Login cl){
         try {
             rut = cl.getRut();
             String sql = "SELECT num FROM tbl_user WHERE perfil=2 AND usuario=? AND clave=?";
             

             Integer userId = jdbcTemplate.queryForObject(sql, new Object[]{cl.getRut(), cl.getContrasena()}, Integer.class);

             if (userId > 0) {
                 return new ModelAndView("redirect:/cliente_add_pedido.htm");
             } else {
                 mav.addObject("msg_error", "Error en el login.");
                 return mav;
             }

         } catch (Exception e) {
             return null;
         }

     }
     
     
     //CONTROLADOR DE MOSTRAR FORMULARIO DE AGREGAR PEDIDO
     @RequestMapping(value = "cliente_add_pedido.htm", method = RequestMethod.GET)
     public ModelAndView addPedido() {
         mav.addObject(new Pedido());
         mav.setViewName("cliente_add_pedido");
         return mav;
     }

     //CONTROLADOR AGREGAR PEDIDO
     @RequestMapping(value = "cliente_add_pedido.htm", method = RequestMethod.POST)
     public ModelAndView addPedido(Pedido pe) {

         String sql = "insert into tbl_pedido(cantidad, tipopan, client, fecha_despacho) values(?,?,(select num from tbl_cliente where rut='"+rut+"'),?)";
         this.jdbcTemplate.update(sql, pe.getCantidad(), pe.getTipopan(), pe.getFecha_despacho());

         return new ModelAndView("redirect:/cliente_add_pedido.htm");
     }
     
     
     //CONTROLADOR DE INGRESO AL FORMULARIO DE LOGIN VISITA
     @RequestMapping(value = "login_visita.htm", method = RequestMethod.GET)
     public ModelAndView LoginVisita() {
         mav.addObject(new Login());
         mav.setViewName("login_visita");
         return mav;
     }
      
     //CONTROLADOR DE LOGIN VISITA     
     @RequestMapping(value = "login_visita.htm", method = RequestMethod.POST)
     public ModelAndView LoginVisita(Login cl){
         try {
             String sql = "SELECT num FROM tbl_user WHERE perfil=3 AND usuario=? AND clave=?";

             Integer userId = jdbcTemplate.queryForObject(sql, new Object[]{cl.getRut(), cl.getContrasena()}, Integer.class);

             if (userId > 0) {
                 return new ModelAndView("redirect:/visita_ver_pedidos.htm");
             } else {
                 mav.addObject("msg_error", "Error en el login.");
                 return mav;
             }

         } catch (Exception e) {
             return null;
         }

     }
     
     
     
     //CONTROLADOR DE VER TODOS LOS PEDIDOS
     @RequestMapping("visita_ver_pedidos.htm")
     public ModelAndView VisitaVerPedidos() {

         String sql = "select\n"
                 + "p.num as idPedido,\n"
                 + "a.nombre as nombreCliente,\n"
                 + "a.direccion as direcciónCliente, \n"
                 + "a.telefono as telefono,\n"
                 + "p.cantidad as cantidadPAn,\n"
                 + "t.nombre as tipoPan,\n"
                 + "p.fecha_pedido as fecha_pedido,\n"
                 + "p.fecha_despacho as fecha_despacho\n"
                 + "from tbl_pedido as p\n"
                 + "join tbl_tipo_pan as t on t.num = p.tipopan\n"
                 + "join tbl_cliente as a on a.num = p.client order by p.num asc";
         List listaDatos = this.jdbcTemplate.queryForList(sql);
         mav.addObject("lista", listaDatos);
         mav.setViewName("visita_ver_pedidos");

         return mav;
     }
     
     
     
     
     
      
      
      
      
      
 }