package textbook;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。
 *
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 示例 :
 *
 * 给定这个链表：1->2->3->4->5
 *
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 *
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 *
 * 说明 :
 *
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 *
 * @author xiechurong
 * @Date 2019/9/24
 */
public class Main {

    public static void test1() {

    }


    public static void main(String[] args) {
        String temp = "INSERT IGNORE INTO `hcg_admin_ops`.`tb_country_code` (`code`, `code2`, `isocode`, `name`, `ename`, `phone`, `timeDiff`, `dominantLcid1`, `dominantLcid2`, `dominantLcid3`, `operator`, `createTime`, `lastUpdateTime`, `status`, `langs`, `sort`, `type`, `subCodes`) \n" +
                "VALUES ('p1', 'p2', 'p3', 'p5', 'p4', '', 'p6', '1033', '1034', '1005', '谢楚荣', '2019-12-31 18:38:38', '1577782109316', '1', '', '1', '1', NULL);\n";
        String pokoCountryCode = "AD,AE,AF,AG,AI,AL,AM,AO,AR,AS,AT,AU,AW,AX,AZ,BA,BB,BD,BE,BG,BH,BI,BJ,BM,BN,BO,BR,BS,BT,BW,BY,BZ,CA,CD,CF,CG,CH,CI,CL,CM,CN,CO,CR,CU,CV,CY,CZ,DE,DJ,DK,DM,DO,DZ,EC,EE,EG,ES,ET,FI,FJ,FM,FR,GA,GB,GD,GE,GF,GH,GM,GN,GP,GQ,GR,GT,GU,GW,GY,HK,HN,HR,HT,HU,ID,IE,IL,IM,IN,IQ,IR,IS,IT,JE,JM,JO,JP,KE,KG,KH,KN,KR,KW,KY,KZ,LA,LB,LC,LI,LK,LR,LT,LU,LV,LY,MA,MD,ME,MG,MK,ML,MM,MN,MO,MP,MQ,MT,MU,MV,MX,MY,MZ,NA,NG,NI,NL,NO,NP,NZ,OM,PA,PE,PH,PK,PL,PR,PS,PT,PW,PY,QA,RE,RO,RS,RU,RW,SA,SC,SD,SE,SG,SI,SK,SL,SN,SO,SR,SV,SY,TC,TG,TH,TJ,TL,TM,TN,TO,TR,TT,TW,TZ,UA,UG,US,UY,UZ,VC,VE,VG,VI,VN,YE,ZA,ZM,ZW";
        List<String> codeSet = Arrays.asList(pokoCountryCode.split(","));
        Map<String,Country> map = new LinkedHashMap<String, Country>(256);
        try {
            BufferedReader reader = new BufferedReader(new FileReader("D:\\a.csv"));
            reader.readLine();
            String line = "";
            while ((line = reader.readLine()) != null) {
                String item[] = line.split(",");
                if (codeSet.contains(item[0])) {
                    Country country = new Country();
                    country.setCode(item[0]);
                    country.setCode2(item[1]);
                    country.setIsoCode(item[2]);
                    country.setName(item[3]);
                    country.setCname(item[4]);
                    country.setTimeDiff(-100);
                    map.put(item[0],country);
                }
            }
            final Set<String> keySet = map.keySet();
            List<String> list = codeSet.stream().filter(o->keySet.contains(o)).collect(Collectors.toList());
            System.out.println(list.size());

            BufferedReader reader1 = new BufferedReader(new FileReader("D:\\b.csv"));
            reader1.readLine();
            while ((line = reader1.readLine()) != null) {
                String item[] = line.split(",");
                if (codeSet.contains(item[0])) {
                    Country country = map.get(item[0]);
                    if (country != null) {
                        country.setTimeDiff(Float.parseFloat(item[1]));
                        map.put(item[0],country);
                    }
                }
            }

            BufferedReader reader2 = new BufferedReader(new FileReader("D:\\countryCode.csv"));
            while ((line = reader2.readLine()) != null) {
                String temp1 = temp;
                String item[] = line.split(",");
                if (item != null && item.length > 0) {
                    String code = item[0];
                    String code2 = item[1];
                    String isoCode = item[2];
                    String cname = item[3];
                    String ename = item[4];
                    String timeDiff = item[5];
                    temp1 = temp1.replaceAll("p1", code).replaceAll("p2", code2).replaceAll("p3", isoCode).replaceAll("p4", cname).replaceAll("p5", ename).replaceAll("p6", timeDiff);
                    System.out.println(temp1);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class Country{
        public Country(){

        }
        private String code;
        private String code2;
        private String isoCode;
        private String ename;
        private String name;
        private float timeDiff;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getCode2() {
            return code2;
        }

        public void setCode2(String code2) {
            this.code2 = code2;
        }

        public String getIsoCode() {
            return isoCode;
        }

        public void setIsoCode(String isoCode) {
            this.isoCode = isoCode;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public float getTimeDiff() {
            return timeDiff;
        }

        public void setTimeDiff(float timeDiff) {
            this.timeDiff = timeDiff;
        }

        public String getCname() {
            return name;
        }

        public void setCname(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return code+","+code2+","+isoCode+","+name+","+name+","+timeDiff;
        }
    }

}
