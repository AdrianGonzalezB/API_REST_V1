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
    private static List<Obra> listaObres = new ArrayList<Obra>();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getObres() {
        return Response.ok(listaObres).build();
    }
    
    
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

    
    @POST
    @Path("/createObra")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createUser(Obra obraRequest) {
 
        this.listaObres.add(obraRequest);
        //return Response.status(Status.CREATED).build();
        return Response.ok(listaObres).build();
 
    }
    
    @GET
    @Path("/name/{AUTOR}")// puesto /name/{autor} por que si no no respondia el servidor y daba error al haber 2 endpoint iguales
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getObraByAuthor(@PathParam("AUTOR") String author) {
        Obra found = null;
        for (int i = 0; i < listaObres.size(); i++) {
            if (listaObres.get(i).getAUTOR().equals(author)) {
                found = listaObres.get(i);
            }
        }
        if (found == null) {
            return Response.status(Status.BAD_REQUEST).entity("Author not found").build();
        } else {
            return Response.ok(found).build();
        }
    }
    
    
    @PUT
    @Path("/updateObra")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateUser(Obra obraUpdate) {
        Obra found = null;
        for (int i = 0; i < listaObres.size(); i++) {
            if (listaObres.get(i).getAUTOR().equalsIgnoreCase(obraUpdate.getAUTOR())) {
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
    
    
    
    @DELETE
    @Path("/deleteObra/{ID_OBRA}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteUser(@PathParam("ID_OBRA") int idObra) {
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
