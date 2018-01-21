package com.projetodoertheia.a5cta.RssNoticias;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * Created by Marcos on 13/08/2016.
 */

//1
public class ReadRss extends AsyncTask<Void,Void,Void>{

    Context context;
//    String address="https://www.sciencemag.org/rss/news_current.xml";
//    String address="http://www.5cta.eb.mil.br/index.php/ultimas-noticias/113-quemvcquerser";
String address="http://www.5cta.eb.mil.br/index.php/ultimas-noticias/113-quemvcquerser";
    ProgressDialog progressDialog;
    ArrayList<FeedItem>feedItems;
    RecyclerView recyclerView;
    URL url;
    public ReadRss(Context context, RecyclerView recyclerView)
    {
        this.recyclerView=recyclerView;
        this.context=context;
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("Carregando....");
    }




    @Override
    protected void onPreExecute() {
        progressDialog.show();
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        progressDialog.dismiss();
        MyAdapter adapter=new MyAdapter(context, feedItems);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        //Decoration do Vertical Space RecyclerView margins
//        recyclerView.addItemDecoration(new VerticalSpace(5));





        recyclerView.setAdapter(adapter);
    }

    @Override
    protected Void doInBackground(Void... params) {
        ProcessXML (Getdata());

        return null;
    }

    private void ProcessXML(Document data) {
        if (data != null) {
            feedItems = new ArrayList<>();
//            ArrayList<FeedItem>feedItems=new ArrayList<>();
//            Log.d("Root", data.getDocumentElement().getNodeName());
            Element root = data.getDocumentElement();
            Node channel = root.getChildNodes().item(1);
            NodeList items = channel.getChildNodes();
            for (int i = 0; i < items.getLength(); i++) {
                Node cureentchild = items.item(i);
                if (cureentchild.getNodeName().equalsIgnoreCase("item")) {
                    FeedItem item = new FeedItem();
                    NodeList itemchilds = cureentchild.getChildNodes();
                    for (int j = 0; j < itemchilds.getLength(); j++) {
                        Node cureent = itemchilds.item(j);
//                        Log.d("textcontent",cureent.getTextContent());
                        if (cureent.getNodeName().equalsIgnoreCase("title")) {
                            item.setTitle(cureent.getTextContent());
                        } else if (cureent.getNodeName().equalsIgnoreCase("description")) {
                            item.setDescription(cureent.getTextContent());
//                        }else if(cureent.getNodeName().equalsIgnoreCase("pubDate")) {
//                            item.setPubDate(cureent.getTextContent());
                        } else if (cureent.getNodeName().equalsIgnoreCase("link")) {
                            item.setLink(cureent.getTextContent());
//                        }else if(cureent.getNodeName().equalsIgnoreCase("media:thumbnail"))
//                        {
//                            String url=cureent.getAttributes().item(0).getTextContent();
//                            item.setThumbnailUrl(url);
//                        }


                        }
                        feedItems.add(item);
//                    Log.d("itemThumbnailUrl", item.getThumbnailUrl());
//                    Log.d("itemDescription", item.getDescription());
//                    Log.d("itemLink", item.getLink());
//                    Log.d("itemPubDate", item.getPubDate());

                    }
                }
            }
        }
    }
    public Document Getdata()
    {
        try {
            url=new URL(address);
            HttpURLConnection connection=(HttpURLConnection)url.openConnection();
            connection.setRequestMethod("GET");
            InputStream inputStream=connection.getInputStream();
            DocumentBuilderFactory builderFactory=DocumentBuilderFactory.newInstance();
            DocumentBuilder builder=builderFactory.newDocumentBuilder();
            Document xmlDoc= builder.parse(inputStream);
            return xmlDoc;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}


