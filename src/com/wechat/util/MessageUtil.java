package com.wechat.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.thoughtworks.xstream.XStream;
import com.wechat.po.TextMessage;

public class MessageUtil {

	public static final String MESSAGE_TEXT = "text";
	public static final String MESSAGE_NEWS = "news";
	public static final String MESSAGE_IMAGE = "image";
	public static final String MESSAGE_VOICE = "voice";
	public static final String MESSAGE_MUSIC = "music";
	public static final String MESSAGE_VIDEO = "video";
	public static final String MESSAGE_LINK = "link";
	public static final String MESSAGE_LOCATION = "location";
	public static final String MESSAGE_EVNET = "event";
	public static final String MESSAGE_SUBSCRIBE = "subscribe";
	public static final String MESSAGE_UNSUBSCRIBE = "unsubscribe";
	public static final String MESSAGE_CLICK = "CLICK";
	public static final String MESSAGE_VIEW = "VIEW";
	public static final String MESSAGE_SCANCODE= "scancode_push";

	public static Map<String, String> xmlToMap(HttpServletRequest request) throws IOException, DocumentException{
		Map<String, String> map = new HashMap<String, String>();
		SAXReader reader = new SAXReader();
		
		InputStream ins = request.getInputStream();
		Document doc = reader.read(ins);
		
		Element root = doc.getRootElement();
		
		@SuppressWarnings("unchecked")
		List<Element> list = root.elements();
		
		for(Element e : list){
			map.put(e.getName(), e.getText());
		}
		ins.close();
		return map;
	}

	public static String textMessageToXml(TextMessage textMessage){
		XStream xstream = new XStream();
		xstream.alias("xml", textMessage.getClass());
		return xstream.toXML(textMessage);
	}

	public static String initText(String toUserName,String fromUserName,String content){
		TextMessage text = new TextMessage();
		text.setFromUserName(toUserName);
		text.setToUserName(fromUserName);
		text.setMsgType(MessageUtil.MESSAGE_TEXT);
		text.setCreateTime(new Date().getTime());
		text.setContent(content);
		return textMessageToXml(text);
	}

	public static String menuText(){
		StringBuffer sb = new StringBuffer();
		sb.append("menuText\n\n");
		sb.append("1firstMenu\n");
		sb.append("2secondMenu\n");
		sb.append("3threeMenu\n\n");
		sb.append("return");
		return sb.toString();
	}
	
	public static String firstMenu(){
		StringBuffer sb = new StringBuffer();
		sb.append("firstMenu");
		return sb.toString();
	}
	
	public static String secondMenu(){
		StringBuffer sb = new StringBuffer();
		sb.append("secondMenu");
		return sb.toString();
	}
	
	public static String threeMenu(){
		StringBuffer sb = new StringBuffer();
		sb.append("translate\n\n");
		
		return sb.toString();
	}

//	public static String newsMessageToXml(NewsMessage newsMessage){
//		XStream xstream = new XStream();
//		xstream.alias("xml", newsMessage.getClass());
//		xstream.alias("item", new News().getClass());
//		return xstream.toXML(newsMessage);
//	}
//	
//
//	public static String imageMessageToXml(ImageMessage imageMessage){
//		XStream xstream = new XStream();
//		xstream.alias("xml", imageMessage.getClass());
//		return xstream.toXML(imageMessage);
//	}
//	
//	public static String musicMessageToXml(MusicMessage musicMessage){
//		XStream xstream = new XStream();
//		xstream.alias("xml", musicMessage.getClass());
//		return xstream.toXML(musicMessage);
//	}
//
//	public static String initNewsMessage(String toUserName,String fromUserName){
//		String message = null;
//		List<News> newsList = new ArrayList<News>();
//		NewsMessage newsMessage = new NewsMessage();
//		
//		News news = new News();
//		news.setTitle("Ä½¿ÎÍø½éÉÜ");
//		news.setDescription("Ä½¿ÎÍøÊÇ´¹Ö±µÄ»¥ÁªÍøIT¼¼ÄÜÃâ·ÑÑ§Ï°ÍøÕ¾¡£ÒÔ¶À¼ÒÊÓÆµ½Ì³Ì¡¢ÔÚÏß±à³Ì¹¤¾ß¡¢Ñ§Ï°¼Æ»®¡¢ÎÊ´ðÉçÇøÎªºËÐÄÌØÉ«¡£ÔÚÕâÀï£¬Äã¿ÉÒÔÕÒµ½×îºÃµÄ»¥ÁªÍø¼¼ÊõÅ£ÈË£¬Ò²¿ÉÒÔÍ¨¹ýÃâ·ÑµÄÔÚÏß¹«¿ªÊÓÆµ¿Î³ÌÑ§Ï°¹úÄÚÁìÏÈµÄ»¥ÁªÍøIT¼¼Êõ¡£Ä½¿ÎÍø¿Î³Ìº­¸ÇÇ°¶Ë¿ª·¢¡¢PHP¡¢Html5¡¢Android¡¢iOS¡¢SwiftµÈITÇ°ÑØ¼¼ÊõÓïÑÔ£¬°üÀ¨»ù´¡¿Î³Ì¡¢ÊµÓÃ°¸Àý¡¢¸ß¼¶·ÖÏíÈý´óÀàÐÍ£¬ÊÊºÏ²»Í¬½×¶ÎµÄÑ§Ï°ÈËÈº¡£");
//		news.setPicUrl("http://zapper.tunnel.mobi/Weixin/image/imooc.jpg");
//		news.setUrl("www.imooc.com");
//		
//		newsList.add(news);
//		
//		newsMessage.setToUserName(fromUserName);
//		newsMessage.setFromUserName(toUserName);
//		newsMessage.setCreateTime(new Date().getTime());
//		newsMessage.setMsgType(MESSAGE_NEWS);
//		newsMessage.setArticles(newsList);
//		newsMessage.setArticleCount(newsList.size());
//		
//		message = newsMessageToXml(newsMessage);
//		return message;
//	}
//
//	public static String initImageMessage(String toUserName,String fromUserName){
//		String message = null;
//		Image image = new Image();
//		image.setMediaId("JTH8vBl0zDRlrrn2bBnMleySuHjVbMhyAo0U2x7kQyd1ciydhhsVPONbnRrKGp8m");
//		ImageMessage imageMessage = new ImageMessage();
//		imageMessage.setFromUserName(toUserName);
//		imageMessage.setToUserName(fromUserName);
//		imageMessage.setMsgType(MESSAGE_IMAGE);
//		imageMessage.setCreateTime(new Date().getTime());
//		imageMessage.setImage(image);
//		message = imageMessageToXml(imageMessage);
//		return message;
//	}
//	
//	public static String initMusicMessage(String toUserName,String fromUserName){
//		String message = null;
//		Music music = new Music();
//		music.setThumbMediaId("WsHCQr1ftJQwmGUGhCP8gZ13a77XVg5Ah_uHPHVEAQuRE5FEjn-DsZJzFZqZFeFk");
//		music.setTitle("see you again");
//		music.setDescription("ËÙ7Æ¬Î²Çú");
//		music.setMusicUrl("http://zapper.tunnel.mobi/Weixin/resource/See You Again.mp3");
//		music.setHQMusicUrl("http://zapper.tunnel.mobi/Weixin/resource/See You Again.mp3");
//		
//		MusicMessage musicMessage = new MusicMessage();
//		musicMessage.setFromUserName(toUserName);
//		musicMessage.setToUserName(fromUserName);
//		musicMessage.setMsgType(MESSAGE_MUSIC);
//		musicMessage.setCreateTime(new Date().getTime());
//		musicMessage.setMusic(music);
//		message = musicMessageToXml(musicMessage);
//		return message;
//	}
}
