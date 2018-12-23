package MemSearch;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class MemSearch {

    public static String[] memSearch (String text) {

        //парсер текста сообщения
        ArrayList<String> textStr = textParse(text);

        //списик для сохранения найденных мемов и частоты их появления
        ArrayList<String> memeUrl = new ArrayList<>();
        ArrayList<Integer> memeFreq = new ArrayList<>();

        //Вызов в цикле поиска мемов, составление списков мемов и частот
        for(String str : textStr){
            Elements mems = htmlParse(str);
            for(Element mem : mems){
                String url = mem.attr("src");

                if(memeUrl.contains(url)){
                    int index = memeUrl.indexOf(url);
                    memeFreq.set(index, memeFreq.get(index)+1);
                } else{
                    memeUrl.add(url);
                    memeFreq.add(1);
                }

            }
        }

        //поиск двух максимальных значений частот
        int maxIndex1 = 0, maxIndex2 = 0;
        for(Integer index : memeFreq){
            if (memeFreq.get(index) > memeFreq.get(maxIndex2)){
                maxIndex2 = index;
            }
            if (memeFreq.get(index) > memeFreq.get(maxIndex1)){
                maxIndex2 = maxIndex1;
                maxIndex1 = index;
            }
        }

        String[] result = new String[2];
        result[0] = memeUrl.get(maxIndex1);
        result[1] = memeUrl.get(maxIndex2);

        return result;
    }

    //парсер текста сообщения. Выделяет само сообщение и все его слова в список строк
    private static ArrayList<String> textParse (String text) {

        ArrayList<String> result = new ArrayList<>();
        result.add(text);

        String[] substr = text.split(" ");

        for (int i = 0; i < substr.length-1; i++) {
            result.add(substr[i]);
        }

        return result;
    }

    //Парсер HTML страницы для поиска мемов
    private static Elements htmlParse (String text) {

        //фаормирование строки для зарпоса на сайт
        StringBuilder strBuild = new StringBuilder();
        strBuild.append("http://1001mem.ru/search?q=");
        strBuild.append(text);

        Elements elements = new Elements();

        //считка HTML страницы и выделение картинок (мемов)
        try {
            Document document = Jsoup.connect(strBuild.toString()).get();
            elements = document.select("img");
            return elements;
        } catch(IOException excep){
            excep.printStackTrace();
        }
        return elements;
    }
}
