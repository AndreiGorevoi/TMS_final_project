package com.news.service.parsingXml;

import com.news.entity.NewsFull;
import com.news.repository.NewsRepository;
import com.news.repository.NewsRepositoryImpl;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ParserFromXML extends DefaultHandler {

        private boolean title=false;
        private String sTitle="";
        private boolean news=false;
        private boolean author=false;
        private String sAuthor="";
        private boolean tag=false;
        private String sTag="";
        private boolean content = false;
        private String sContent="";
        private boolean rate = false;
        private double dRate = 0;

        NewsRepository newsRepository = new NewsRepositoryImpl();

        public void startElement(String uri, String localName, String qName, Attributes attributes){
            if(qName.equalsIgnoreCase("news")){

            }
            if(qName.equalsIgnoreCase("title")){
                title=true;
            }
            if(qName.equalsIgnoreCase("rate")){
                rate=true;
            }
            if(qName.equalsIgnoreCase("author")){
                author=true;
            }
            if(qName.equalsIgnoreCase("content")){
                content=true;

            }
            if(qName.equalsIgnoreCase("tag")){
                tag=true;
            }

        }
        public void endElement(String uri, String localName, String qName){
            if(title){
                title=false;
            }
            if(rate){
                rate=false;
            }
            if(author){
                author=false;
            }
            if(content){
                content=false;

            }
            if(tag){
                tag=false;
            }

            if(qName.equalsIgnoreCase("news")){
                NewsFull news_full = new NewsFull();
                news_full.setTitle(sTitle);
                news_full.setRate(dRate);
                news_full.setName_author(sAuthor);
                news_full.setContent(sContent);
                news_full.setName_tag(sTag);
                newsRepository.addNews(news_full);
            }
        }

        public void characters(char[] ch, int start, int length) throws SAXException {
            if(title){
                sTitle=new String(ch,start,length);
            }
            if(rate){
                dRate=Double.valueOf(new String(ch,start,length));
            }
            if(author){
                sAuthor=new String(ch,start,length);
            }
            if(content){
                sContent=new String(ch,start,length);
            }
            if(tag){
                sTag=new String(ch,start,length);
            }

            super.characters(ch,start,length);
        }


    }

