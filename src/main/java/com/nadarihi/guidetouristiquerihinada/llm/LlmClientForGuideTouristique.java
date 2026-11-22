package com.nadarihi.guidetouristiquerihinada.llm;

import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.chat.request.ResponseFormat;
import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;
import dev.langchain4j.service.AiServices;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class LlmClientForGuideTouristique {

    private GuideTouristique guide;

    @PostConstruct
    public void init() {
        String cle = System.getenv("GEMINI_KEY"); // même variable que dans le TP 2
        ChatModel modele = GoogleAiGeminiChatModel.builder()
                .apiKey(cle)
                .modelName("gemini-3.8-flash")
                .responseFormat(ResponseFormat.JSON)
                .maxRetries(5)
                .build();
        guide = AiServices.create(GuideTouristique.class, modele);
    }

    public String ask(String lieu) {
        return guide.ask(lieu);
    }
}