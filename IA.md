# Questions posées à l'IA

## Question 1 : Pourquoi le statut HTTP 500 s'affiche-t-il ?

**Réponse :** Le code 500 (Internal Server Error) signifie que le serveur a rencontré une erreur pendant le traitement de la requête. Ici, mon application REST fonctionnait, mais l'appel à l'API Gemini a échoué (modèle inexistant, serveur Google surchargé, quota dépassé). LangChain4j a levé une `RuntimeException`, que la méthode REST n'a pas interceptée, donc Payara a renvoyé une erreur 500 au navigateur. Le 500 vient donc de l'API du LLM, pas d'un bug dans l'URL ou dans JAX-RS.

## Question 2 : Pourquoi j'ai eu 429 RESOURCE_EXHAUSTED au Run, mais le LLM répond après avoir seulement arrêté et relancé ?

**Réponse :** Le 429 signifie que le quota gratuit de Gemini était atteint (20 requêtes par jour et par modèle). Ce quota est côté Google, pas côté application : relancer le serveur ne le remet pas à zéro. Si le LLM a répondu après l'arrêt et le relancement, les causes les plus probables sont :

- le quota avait été réinitialisé entre-temps (il se renouvelle chaque jour) ;
- ou la configuration avait changé (autre modèle, ou autre clé API lue au redémarrage, car la variable d'environnement n'est lue qu'au démarrage de l'application).
  Un Stop/Run recharge la configuration, mais ne réinitialise pas le quota.
 