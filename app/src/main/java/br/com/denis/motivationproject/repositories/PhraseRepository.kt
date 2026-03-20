package br.com.denis.motivationproject.repositories

import br.com.denis.motivationproject.helpers.MotivationConstants
import kotlin.random.Random

data class Phrase(
    val description: String,
    val category: Int,
    val language: Int
)

class PhraseRepository {

    private val happy = MotivationConstants.PHRASE.HAPPY
    private val sunny = MotivationConstants.PHRASE.SUNNY
    private val all = MotivationConstants.PHRASE.ALL

    private val langEn = MotivationConstants.LANGUAGE.ENGLISH
    private val langPt = MotivationConstants.LANGUAGE.PORTUGUESE
    private val langDe = MotivationConstants.LANGUAGE.DEUTSCH
    private val langFi = MotivationConstants.LANGUAGE.FINNISH

    private val listPhrase: List<Phrase> = listOf(

        // 🇧🇷 PT
        Phrase("Não sabendo que era impossível, foi lá e fez.", happy, langPt),
        Phrase("Você não é derrotado quando perde, você é derrotado quando desiste!", happy, langPt),
        Phrase("Quando está mais escuro, vemos mais estrelas!", happy, langPt),
        Phrase("Insanidade é fazer sempre a mesma coisa e esperar um resultado diferente.", happy, langPt),
        Phrase("Não pare quando estiver cansado, pare quando tiver terminado.", happy, langPt),
        Phrase("A melhor maneira de prever o futuro é inventá-lo.", sunny, langPt),
        Phrase("Você perde todas as chances que você não aproveita.", sunny, langPt),
        Phrase("Fracasso é o condimento que dá sabor ao sucesso.", sunny, langPt),
        Phrase("Riscos devem ser corridos, porque o maior perigo é não arriscar nada!", sunny, langPt),

        // 🇺🇸 EN
        Phrase("Don’t stop when you’re tired, stop when you’re done.", happy, langEn),
        Phrase("The best way to predict the future is to create it.", sunny, langEn),
        Phrase("You miss 100% of the chances you don’t take.", sunny, langEn),

        // 🇩🇪 DE
        Phrase("Hör nicht auf, wenn du müde bist, hör auf, wenn du fertig bist.", happy, langDe),
        Phrase("Der beste Weg, die Zukunft vorherzusagen, ist, sie zu erschaffen.", sunny, langDe),

        // 🇫🇮 FI
        Phrase("Älä lopeta, kun olet väsynyt, lopeta kun olet valmis.", happy, langFi),
        Phrase("Paras tapa ennustaa tulevaisuus on luoda se.", sunny, langFi)
    )

    fun getPhrase(filter: Int, language: Int): String {
        val filtered = listPhrase.filter {
            (it.category == filter || filter == all) &&
                    it.language == language
        }

        val rand = Random.nextInt(filtered.size)
        return filtered[rand].description
    }
}