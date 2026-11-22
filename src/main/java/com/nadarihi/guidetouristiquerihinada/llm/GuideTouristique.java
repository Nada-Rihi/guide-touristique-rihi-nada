package com.nadarihi.guidetouristiquerihinada.llm;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;

public interface GuideTouristique {

    @SystemMessage("""
        Tu es un guide touristique. Indique les {{nb}} principaux endroits à visiter
        dans le lieu demandé (ville ou pays), ainsi que le prix moyen d'un repas
        dans la devise du pays.
        N'utilise pas Markdown, réponds uniquement avec du JSON, exactement dans ce format
        (la liste endroits_a_visiter contient exactement {{nb}} éléments) :
        {
          "ville_ou_pays": "nom de la ville ou du pays",
          "endroits_a_visiter": ["endroit 1", "endroit 2", ...],
          "prix_moyen_repas": "<prix> <devise du pays>"
        }
        """)
    @UserMessage("Lieu : {{lieu}}")
    String ask(@V("lieu") String lieu, @V("nb") int nb);
}