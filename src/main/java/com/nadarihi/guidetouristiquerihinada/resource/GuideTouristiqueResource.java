package com.nadarihi.guidetouristiquerihinada.resource;

import com.nadarihi.guidetouristiquerihinada.llm.LlmClientForGuideTouristique;
import jakarta.inject.Inject;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/guide")
public class GuideTouristiqueResource {

    @Inject
    private LlmClientForGuideTouristique llmClient;

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
    // /**
    //  * Retourne des informations touristiques sur une ville ou un pays.
    //  *
    //  * @param villeOuPays le nom de la ville ou du pays
    //  * @return un tableau JSON contenant, pour le moment, le nom du lieu
    //  */
    // @GET
    // @Path("lieu/{ville_ou_pays}")
    // @Produces(MediaType.APPLICATION_JSON)
    // public String[] endroitsDeVisite(@PathParam("ville_ou_pays") String villeOuPays) {
    //     return new String[] { villeOuPays };
    // }

    // Test 3 : réponse du LLM (nombre d'endroits fixé à 2)
    // /**
    //  * Retourne des informations touristiques sur une ville ou un pays,
    //  * fournies par le LLM.
    //  *
    //  * @param villeOuPays le nom de la ville ou du pays
    //  * @return une réponse JSON avec les endroits à visiter et le prix moyen d'un repas
    //  */
    // @GET
    // @Path("lieu/{ville_ou_pays}")
    // @Produces(MediaType.APPLICATION_JSON)
    // public Response endroitsDeVisite(@PathParam("ville_ou_pays") String villeOuPays) {
    //     String reponseJson = llmClient.ask(villeOuPays);
    //     return Response.ok(reponseJson).build();
    // }

    // Bonus : nombre d'endroits donné en paramètre de requête (?nb=4)
    /**
     * Retourne des informations touristiques sur une ville ou un pays,
     * fournies par le LLM.
     *
     * @param villeOuPays le nom de la ville ou du pays
     * @param nb le nombre d'endroits à visiter (2 par défaut)
     * @return une réponse JSON avec les endroits à visiter et le prix moyen d'un repas
     */
    @GET
    @Path("lieu/{ville_ou_pays}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response endroitsDeVisite(@PathParam("ville_ou_pays") String villeOuPays,
                                     @QueryParam("nb") @DefaultValue("2") int nb) {
        String reponseJson = llmClient.ask(villeOuPays, nb);
        return Response.ok(reponseJson).build();
    }
}