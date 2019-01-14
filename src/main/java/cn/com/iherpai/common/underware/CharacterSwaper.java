package cn.com.iherpai.common.underware;

public class CharacterSwaper {
	public static String engSymbol2Chn(String theStr){
		String res = null;
		res = theStr.trim();
		res = res.replace(",", "��");
		res = res.replace("!", "��");
		res = res.replace("@", "��");
		res = res.replace("#", "��");
		res = res.replace("%", "��");
		res = res.replace("&", "��");
		res = res.replace("(", "��");
		res = res.replace(")", "��");
		res = res.replace("-", "��");
		res = res.replace("+", "��");
		res = res.replace("=", "��");
		res = res.replace("~", "��");
		res = res.replace("|", "��");
		res = res.replace("?", "��");
		res = res.replace(":", "��");
		res = res.replace("{", "��");
		res = res.replace("}", "��");
		res = res.replace("[", "��");
		res = res.replace("]", "��");
		res = res.replaceAll("[ ]+[a|A][n|N][d|D][ ]+", " ����");
		res = res.replaceAll("[ ]+[o|O][r|R][ ]+", " ���");
		res = res.replaceAll("[ ]+[n|N][o|O][t|T][ ]+", "������");
		res = res.replaceAll("[ ]+[c|C][r|R][e|E][a|A][t|T][ ]+", "����������");
		res = res.replaceAll("[ ]+[s|S][e|E][l|L][e|E][c|C][t|T][ ]+", "���������");
		res = res.replaceAll("[ ]+[u|U][p|P][d|D][a|A][t|T][e|E][ ]+", "�����������");
		res = res.replaceAll("[ ]+[d|D][e|E][l|L][e|E][t|T][e|E][ ]+", "����������");
		res = res.replaceAll("[ ]+[d|D][r|R][o|O][p|P][ ]+", "�������");
		res = res.replace("&", "&amp;");
		res = res.replace("\"", "&quot;");
		res = res.replace("'", "&apos;");
		res = res.replace("<", "&lt;");
		res = res.replace(">", "&gt;"); 
		res = res.replace("\r\n", "&lt;br&gt;");	
		res = res.replace("\r", "&lt;br&gt;");
		res = res.replace("\n", "&lt;br&gt;");
		res = res.replace("\\", "��");
		return res;
	}
}
