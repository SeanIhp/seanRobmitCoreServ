package cn.com.iherpai.common.utils;
import java.text.SimpleDateFormat;   
import java.util.Calendar;   
import java.util.Date;   
import java.util.GregorianCalendar;   
import java.util.HashMap;   
import java.util.Map;   
import java.util.Set;   
  
/**  
 *         <p>  
 *         ��˵��:��ȡ���֤�����Ϣ  
 *         </p>  
 */  
public class IdcardInfoExtractor {   
    // ʡ��   
    private String province;   
    // ����   
    private String city;   
    // ����   
    private String region;   
    // ���   
    private int year;   
    // �·�   
    private int month;   
    // ����   
    private int day;   
    // �Ա�   
    private String gender;   
    // ��������   
    private Date birthday;   
  
    private Map<String, String> cityCodeMap = new HashMap<String, String>() {   
        {   
            this.put("11", "����");   
            this.put("12", "���");   
            this.put("13", "�ӱ�");   
            this.put("14", "ɽ��");   
            this.put("15", "���ɹ�");   
            this.put("21", "����");   
            this.put("22", "����");   
            this.put("23", "����");   
            this.put("31", "�Ϻ�");   
            this.put("32", "����");   
            this.put("33", "�㽭");   
            this.put("34", "����");   
            this.put("35", "����");   
            this.put("36", "����");   
            this.put("37", "ɽ��");   
            this.put("41", "����");   
            this.put("42", "����");   
            this.put("43", "����");   
            this.put("44", "�㶫");   
            this.put("45", "����");   
            this.put("46", "����");   
            this.put("50", "����");   
            this.put("51", "�Ĵ�");   
            this.put("52", "����");   
            this.put("53", "����");   
            this.put("54", "����");   
            this.put("61", "����");   
            this.put("62", "����");   
            this.put("63", "�ຣ");   
            this.put("64", "����");   
            this.put("65", "�½�");   
            this.put("71", "̨��");   
            this.put("81", "���");   
            this.put("82", "����");   
            this.put("91", "����");   
        }   
    };   
       
    private IdcardValidator validator = null;   
       
    /**  
     * ͨ���췽����ʼ��������Ա����  
     */  
    public IdcardInfoExtractor(String idcard) {   
        try {   
            validator = new IdcardValidator();   
            if (validator.isValidatedAllIdcard(idcard)) {   
                if (idcard.length() == 15) {   
                    idcard = validator.convertIdcarBy15bit(idcard);   
                }   
                // ��ȡʡ��   
                String provinceId = idcard.substring(0, 2);   
                Set<String> key = this.cityCodeMap.keySet();   
                for (String id : key) {   
                    if (id.equals(provinceId)) {   
                        this.province = this.cityCodeMap.get(id);   
                        break;   
                    }   
                }   
  
                // ��ȡ�Ա�   
                String id17 = idcard.substring(16, 17);   
                if (Integer.parseInt(id17) % 2 != 0) {   
                    this.gender = "��";   
                } else {   
                    this.gender = "Ů";   
                }   
  
                // ��ȡ��������   
                String birthday = idcard.substring(6, 14);   
                Date birthdate = new SimpleDateFormat("yyyyMMdd")   
                        .parse(birthday);   
                this.birthday = birthdate;   
                GregorianCalendar currentDay = new GregorianCalendar();   
                currentDay.setTime(birthdate);   
                this.year = currentDay.get(Calendar.YEAR);   
                this.month = currentDay.get(Calendar.MONTH) + 1;   
                this.day = currentDay.get(Calendar.DAY_OF_MONTH);   
            }   
        } catch (Exception e) {   
            e.printStackTrace();   
        }   
    }   
  
    /**  
     * @return the province  
     */  
    public String getProvince() {   
        return province;   
    }   
  
    /**  
     * @return the city  
     */  
    public String getCity() {   
        return city;   
    }   
  
    /**  
     * @return the region  
     */  
    public String getRegion() {   
        return region;   
    }   
  
    /**  
     * @return the year  
     */  
    public int getYear() {   
        return year;   
    }   
  
    /**  
     * @return the month  
     */  
    public int getMonth() {   
        return month;   
    }   
  
    /**  
     * @return the day  
     */  
    public int getDay() {   
        return day;   
    }   
  
    /**  
     * @return the gender  
     */  
    public String getGender() {   
        return gender;   
    }   
  
    /**  
     * @return the birthday  
     */  
    public Date getBirthday() {   
        return birthday;   
    }   
  
    @Override  
    public String toString() {   
        return "ʡ�ݣ�" + this.province + ",�Ա�" + this.gender + ",�������ڣ�"  
                + this.birthday;   
    }   
  
    public static void main(String[] args) {   
        String idcard = "";   
        IdcardInfoExtractor ie = new IdcardInfoExtractor(idcard);   
        System.out.println(ie.toString());   
    }   
}
