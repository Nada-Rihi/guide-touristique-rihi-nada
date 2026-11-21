package com.nadarihi.guidetouristiquerihinada.resource;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/guide")
public class GuideTouristiqueResource {

    // Test 1 : retourner juste la valeur du paramètre
    // /**
    //  * Retourne des informations touristiques sur une ville ou un pays.
    //  *
    //  * @param villeOuPays le nom de la ville ou du pays
    //  * @return pour le moment, la valeur du paramètre
    //  */
    // @GET
    // @Path("lieu/{ville_ou_pays}")
    // @Produces(MediaType.APPLICATION_JSON)
    // public String endroitsDeVisite(@PathParam("ville_ou_pays") String villeOuPays) {
    //     return villeOuPays;
    // }

    // Test 2 : retourner un tableau de String
    /**
     * Retourne des informations touristiques sur une ville ou un pays.
     *
     * @param villeOuPays le nom de la ville ou du pays
     * @return un tableau JSON contenant, pour le moment, le nom du lieu
     */
    @GET
    @Path("lieu/{ville_ou_pays}")
    @Produces(MediaType.APPLICATION_JSON)
    public String[] endroitsDeVisite(@PathParam("ville_ou_pays") String villeOuPays) {
        return new String[] { villeOuPays };
    }
}