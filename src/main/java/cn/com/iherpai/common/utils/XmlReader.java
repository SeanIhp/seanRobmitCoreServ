package cn.com.iherpai.common.utils;

import java.io.*;
import java.util.*;
import javax.servlet.ServletContext;
import org.jdom.*;
import org.jdom.input.*;
import org.jdom.output.XMLOutputter;

import cn.com.iherpai.common.consts.GroupConfig;

import org.jdom.output.Format;


public class XmlReader {

	
	
	public void createXML(String fileName) {
		Element root = new Element("siteParams");
		Document doc = new Document(root);
		Element param1 = new Element("parameter");
		Element param2 = new Element("parameter");

		param1.addContent(new Element("name").addContent("comment_listSize_of_articleStd"));		
		param1.addContent(new Element("value").addContent("10"));
		param2.addContent(new Element("name").addContent("comment_pageCount_of_commentList"));
		param2.addContent(new Element("value").addContent("5"));		
		root.addContent(param1);
		root.addContent(param2);
		try {
			XMLOutputter outer = new XMLOutputter(Format.getPrettyFormat().setEncoding("utf-8"));
			outer.output(doc, new FileOutputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	

	public void readXML(String fileName, ServletContext sc) {
		Document myDoc = null;
		try {
			SAXBuilder sb = new SAXBuilder();
			myDoc = sb.build(new FileInputStream(fileName));
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Element root = myDoc.getRootElement(); 
		List params = root.getChildren();
		for (Iterator iter1 = params.iterator(); iter1.hasNext();) {
			Element param = (Element) iter1.next();
			sc.setAttribute(param.getChild("name").getText(), param.getChild("value").getText());
		}
	}
	
	
	
	@SuppressWarnings({ "unchecked", "unchecked" })
	public static GroupConfig readGroupConfig(String fileName) {
		GroupConfig res = new GroupConfig();
		Document myDoc = null;
		try {
			SAXBuilder sb = new SAXBuilder();
			myDoc = sb.build(new FileInputStream(fileName));
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Element root = myDoc.getRootElement(); 
		List params = root.getChildren();
		GroupConfig gc = new GroupConfig();
		Element param = root.getChild("createConfig");
		if( param.getName().equals("createConfig") ){
			gc.setCreateDelay( new Boolean(param.getChild("createDelay").getText()) );
			gc.setCreateDelayValue( new Integer(param.getChild("createDelayValue").getText()) );
			gc.setCreateDelayText( new Integer(param.getChild("createDelayText").getText()) );
			gc.setCreateDelayUnitText( param.getChild("createDelayUnitText").getText() );
			//separator---------------
			gc.setCustomIcon( new Boolean(param.getChild("customIcon").getText()) );
			//separator---------------
			gc.setFansBottomLine( new Boolean(param.getChild("fansBottomLine").getText()) );
			gc.setFansBottomLineValue( new Integer(param.getChild("fansBottomLineValue").getText()) );
			//separator---------------
			gc.setTopicBottomLine( new Boolean(param.getChild("topicBottomLine").getText()) );
			gc.setTopicBottomLineValue( new Integer(param.getChild("topicBottomLineValue").getText()) );
			//separator---------------
			gc.setGroupsTopLine( new Boolean(param.getChild("groupsTopLine").getText()) );
			gc.setGroupsTopLineDefaultValue( new Integer(param.getChild("groupsTopLineDefaultValue").getText()) );
			//separator---------------
			List gtlc = param.getChild("groupsTopLineConfig").getChildren();
			Map tempMap1 = new HashMap(0);
			for (Iterator iter2 = gtlc.iterator(); iter2.hasNext();) {
				Element param2 = (Element) iter2.next();
				tempMap1.put(new Integer(param2.getChild("userLevel").getText()), new Integer(param2.getChild("groupsTopLineValue").getText()));
			}
			gc.setGroupsTopLineConfig(tempMap1);
			//separator---------------
			gc.setMemberTopLine( new Boolean(param.getChild("memberTopLine").getText()) );
			gc.setMemberTopLineDefaultValue( new Integer(param.getChild("memberTopLineDefaultValue").getText()) );
			List mtlc = param.getChild("memberTopLineConfig").getChildren();
			Map tempMap2 = new HashMap(0);
			for (Iterator iter3 = mtlc.iterator(); iter3.hasNext();) {
				Element param3 = (Element) iter3.next();
				tempMap2.put(new Integer(param3.getChild("groupLevel").getText()), new Integer(param3.getChild("memberTopLineValue").getText()));
			}
			gc.setMemberTopLineConfig(tempMap2);
		}
		return res;
	}
	
	
	
	
	
	
	
	/*
	@SuppressWarnings({ "unchecked", "unchecked" })
	public ArrayList<LiveScheme> readLiveScheme(String fileName) {
		ArrayList<LiveScheme> res = new ArrayList<LiveScheme>();
		Document myDoc = null;
		try {
			SAXBuilder sb = new SAXBuilder();
			myDoc = sb.build(new FileInputStream(fileName));
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Element root = myDoc.getRootElement(); 
		List params = root.getChildren();
		for (Iterator iter1 = params.iterator(); iter1.hasNext();) {
			Element param = (Element) iter1.next();
			LiveScheme scheme = new LiveScheme();
			scheme.setTheDate( param.getChild("theDate").getText() );
			scheme.setTheWeekDay( param.getChild("theWeekDay").getText() );
			scheme.setTheTime( param.getChild("theTime").getText() );
			scheme.setProgramName( param.getChild("programName").getText() );
			scheme.setProgramLength( param.getChild("programLength").getText() );
			scheme.setProgramLengthUnit( param.getChild("programLengthUnit").getText() );
			scheme.setLiveGoodsInfo(new ArrayList<LiveScheme>(0));
			List subParams = param.getChildren("goodsInfo");
			for (Iterator subIter = subParams.iterator(); subIter.hasNext();) {
				String[] report = new String[7];
				Element subObject = (Element) subIter.next();
				report[0] = subObject.getChild("goodsLiveTime").getText();
				report[1] = subObject.getChild("goodsF3Id").getText();
				report[2] = subObject.getChild("goodsName").getText();
				report[3] = subObject.getChild("goodsSubHead").getText();
				report[4] = subObject.getChild("goodsReferencePrice").getText();
				report[5] = subObject.getChild("goodsPrice").getText();
				report[6] = subObject.getChild("goodsUrl").getText();
				ArrayList ii = scheme.getLiveGoodsInfo();
				ii.add(report);
				scheme.setLiveGoodsInfo(ii);
			}		
			res.add(scheme);
		}
		return res;
	}

	
	
	
	
	
	@SuppressWarnings({ "unchecked", "unchecked" })
	public ArrayList<FocusAdvert> readFocusAdvert(String fileName) {
		ArrayList<FocusAdvert> res = new ArrayList<FocusAdvert>();
		Document myDoc = null;
		try {
			SAXBuilder sb = new SAXBuilder();
			myDoc = sb.build(new FileInputStream(fileName));
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Element root = myDoc.getRootElement(); 
		List params = root.getChildren();
		for (Iterator iter1 = params.iterator(); iter1.hasNext();) {
			Element param = (Element) iter1.next();
			FocusAdvert adv = new FocusAdvert();
			adv.setTitle( param.getChild("theTitle").getText() );
			adv.setUrl( param.getChild("theUrl").getText() );
			adv.setBigImage( param.getChild("theBigImage").getText() );
			adv.setBigImageAlt( param.getChild("theBigImageAlt").getText() );
			adv.setSmallImage( param.getChild("theSmallImage").getText() );
			adv.setSmallImageAlt( param.getChild("theSmallImageAlt").getText() );			
			res.add(adv);
		}
		return res;
	}

	
	
	
	
	
	@SuppressWarnings({ "unchecked", "unchecked" })
	public ArrayList<MegaNews> readMegaNews(String fileName) {
		ArrayList<MegaNews> res = new ArrayList<MegaNews>();
		Document myDoc = null;
		try {
			SAXBuilder sb = new SAXBuilder();
			myDoc = sb.build(new FileInputStream(fileName));
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Element root = myDoc.getRootElement(); 
		List params = root.getChildren();
		for (Iterator iter1 = params.iterator(); iter1.hasNext();) {
			Element param = (Element) iter1.next();
			MegaNews news = new MegaNews();
			news.setTitle( param.getChild("theTitle").getText() );
			news.setTitleColor( param.getChild("theTitleColor").getText() );
			news.setUrl( param.getChild("theUrl").getText() );
			news.setUrlAlt( param.getChild("theUrlAlt").getText() );
			news.setBigImage( param.getChild("theBigImage").getText() );
			news.setBigImageAlt( param.getChild("theBigImageAlt").getText() );
			news.setSmallImage( param.getChild("theSmallImage").getText() );
			news.setSmallImageAlt( param.getChild("theSmallImageAlt").getText() );			
			res.add(news);
		}
		return res;
	}

	
	
	
	
	
	@SuppressWarnings({ "unchecked", "unchecked" })
	public ArrayList<SimpleVoteItem> loadMarkDepVote2Database(String fileName) {
		ArrayList<SimpleVoteItem> res = new ArrayList<SimpleVoteItem>(0);
		Document myDoc = null;
		try {
			SAXBuilder sb = new SAXBuilder();
			FileInputStream fin = new FileInputStream(fileName);
			myDoc = sb.build(new FileInputStream(fileName));
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
				
		Element root = myDoc.getRootElement(); 
		List params = root.getChildren();
		String theVoteCode = "";
		String theVoteTitle = "";
		String theChoicerType = "";
			Element param = root;
			theVoteCode = param.getChild("theVoteCode").getText();
			theVoteTitle = param.getChild("theVoteTitle").getText();
			theChoicerType = param.getChild("theChoicerType").getText();
			List subParams = param.getChildren("theVoteItem");
			for (Iterator subIter = subParams.iterator(); subIter.hasNext();) {
				SimpleVoteItem svi = new SimpleVoteItem();
				String theItm = "";
				svi.setVoteCode( theVoteCode );
				svi.setVoteTitle( theVoteTitle );
				svi.setChoiceType( theChoicerType );
				String[] report = new String[10];
				Element subObject = (Element) subIter.next();
				svi.setSerialCode( new Long(subObject.getChild("theSerialCode").getText()) );
				report[0] = subObject.getChild("theItemText1").getText();
				report[1] = subObject.getChild("theItemText2").getText();
				report[2] = subObject.getChild("theItemText3").getText();
				report[3] = subObject.getChild("theItemText4").getText();
				report[4] = subObject.getChild("theItemText5").getText();
				report[5] = subObject.getChild("theItemText6").getText();
				report[6] = subObject.getChild("theItemText7").getText();
				report[7] = subObject.getChild("theItemText8").getText();
				report[8] = subObject.getChild("theItemText9").getText();
				report[9] = subObject.getChild("theItemText10").getText();
				for(int x=0; x<10; x++){
					if(report[x]==null || report[x].trim().equals(" ") ){
						report[x]=" "; 
					}
					if(x!=0){
						theItm=theItm+","+report[x];
					}else{
						theItm=theItm+report[x];
					}
				}			
				svi.setSortCode( subObject.getChild("theSortCode").getText() );
				svi.setVoteItemTexts(theItm);
				svi.setItemVoteCount(new Long(0));
				res.add(svi);	
			}		
		return res;
	}
	*/
	
	
	
}
