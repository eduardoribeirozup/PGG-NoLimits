package com.pgg.listarreddit;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ListarTopicos {
    public static final String site = "https://www.reddit.com/r/programming/";
    
    public static List<String> retornaTopicos() throws IOException {
        List<String> titulos = new ArrayList <String>();
        
        Document doc = Jsoup.connect(site).get();
        Elements topicos = doc.getElementsByClass("y8HYJ-y_lTUHkQIc1mdCq _2INHSNB8V5eaWp4P0rY_mE");
            
        for (Element topico: topicos) {
            titulos.add(topico.getElementsByClass("SQnoC3ObvgnGjWt90zD9Z _2INHSNB8V5eaWp4P0rY_mE").text());              
        }
        
        return titulos;
    }
}
