/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.api_rest_v1;
import java.util.ArrayList;
import java.util.List;
 
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
/**
 *
 * @author Adri
 */

@Path("/obres")
public class ServicioObres {
    private static List<Obra> listaObres = new ArrayList<Obra>() {
        {
            add(new Obra(1,"Prueba","1956","Art","Yo"));
            add(new Obra(2,"Prueba","1956","Art","Yo"));
        }
    };
    
    /**
     *
     * @return devuelve una respuesta
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getObres() {
        return Response.ok(listaObres).build();
    }
    
    /**
     *
     * @param id pide el id a buscar de la obra
     * @return devuelve una respuesta
     */
    @GET
    @Path("/{ID_OBRA}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getObraById(@PathParam("ID_OBRA") int id) {
        Obra found = null;
        for (int i = 0; i < listaObres.size(); i++) {
            if (listaObres.get(i).getID_OBRA() == id) {
                found = listaObres.get(i);
            }
        }
        if (found == null) {
            return Response.status(Status.BAD_REQUEST).entity("Obra not found").build();
        } else {
            return Response.ok(found).build();
        }
    }

    /**
     *
     * @param obraRequest pide la obra a crear
     * @return devuelve una respuesta
     */
    @POST
    @Path("/createObra")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createObra(Obra obraRequest) {
 
        this.listaObres.add(obraRequest);
        //return Response.status(Status.CREATED).build();
        return Response.ok(listaObres).build();
 
    }
    
    /**
     *
     * @param author pide el autor a buscar
     * @return devuelve una respuesta
     */
    @GET
    @Path("/name/{AUTOR}")// puesto /name/{autor} por que si no no respondia el servidor y daba error al haber 2 endpoint iguales
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getObraByAuthor(@PathParam("AUTOR") String author) {
        ArrayList<Obra> founList = new ArrayList<>();
        
        for (int i = 0; i < listaObres.size(); i++) {
            if (listaObres.get(i).getAUTOR().equals(author)) {
                founList.add(listaObres.get(i));
               
            }
        }
        if (founList == null) {
            return Response.status(Status.BAD_REQUEST).entity("Author not found").build();
        } else {
            return Response.ok(founList).build();
        }
    }
    
    /**
     *
     * @param obraUpdate pide la obra a actualizar
     * @return devuelve una respuesta
     */
    @PUT
    @Path("/updateObra")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateObra(Obra obraUpdate) {
        Obra found = null;
        for (int i = 0; i < listaObres.size(); i++) {
            if (listaObres.get(i).getID_OBRA() == obraUpdate.getID_OBRA()) {
                found = listaObres.get(i);
            }
        }
 
        if (found == null) {
            return Response.status(Status.BAD_REQUEST).entity("Obra not found").build();
        } else {
            found.setID_OBRA(obraUpdate.getID_OBRA());
            found.setTITOL(obraUpdate.getTITOL());
            found.setANY(obraUpdate.getANY());
            found.setMODALITAT(obraUpdate.getMODALITAT());
            found.setAUTOR(obraUpdate.getAUTOR());
            return Response.ok(found).build();
        }
    }
    
    /**
     *
     * @param idObra pide el id de la obra a eliminar
     * @return devuelve una respuesta 
     */
    @DELETE
    @Path("/deleteObra/{ID_OBRA}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteObra(@PathParam("ID_OBRA") int idObra) {
        Obra found = null;
        for (int i = 0; i < listaObres.size(); i++) {
            if (listaObres.get(i).getID_OBRA() == idObra) {
                found = listaObres.get(i);
                listaObres.remove(found);
            }
        }
 
        if (found == null) {
            return Response.status(Status.BAD_REQUEST).entity("User not found").build();
        } else {
            return Response.ok(listaObres).build();
        }
    }
}
