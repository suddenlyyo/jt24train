package cn.bdqn.dom4j;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;


public class Dom4jTest {

    public static void main(String[] args) throws Exception {

        createXML();
        parseXML("D:" + File.separator + "lol.xml");


    }

    // 创建一个XML文件

    public static void createXML() throws IOException {

        //借助文档助手创建根元素
        Element root = DocumentHelper.createElement("lol");
        Document document = DocumentHelper.createDocument(root);


        root.addAttribute("id", "Tencent");
        root.addAttribute("company", "腾讯游戏");
        root.addAttribute("slogan", "用心创造游戏");
        Element legend = root.addElement("hero");
        legend.addAttribute("id", "107");
        legend.addAttribute("name", "劫");
        legend.addAttribute("fullName", "影流之主");
        Element skillQ = legend.addElement("Q");
        skillQ.setText("劫和他的影分身一起将他们的手里剑向前方掷出，每一枚手里剑都会对命中的第一个敌人造成70/105/140/175/210(+0.9)物理伤害，"
                + "并对之后的每个敌人造成42/63/84/105/126(+0.6）物理伤害。"
                + "如果有多枚手里剑命中同一目标，则每一枚额外的手里剑所造成的伤害会比前一枚减少25%。冷却时间：6消耗：75/70/65/60/55能量射程：900");
        skillQ.addAttribute("name", "诸刃");
        skillQ.addAttribute("value", "均衡，脆弱无比");
        Element skillW = legend.addElement("W");
        skillW.setText("被动：获得4/8/12/16/20%的额外攻击力加成。主动：劫的影分身向前冲锋，并残留4.5秒。再次激活此技能将会让劫与影分身交换位置。"
                + "劫的影分身会模仿他的技能。如果有任一技能同时命中了两次相同目标的话，那么劫会回复20/25/30/35/40能量。每个被模仿的技能只会回复一次能量。"
                + "消耗：40/35/30/25/20能量冷却时间：22/20/18/16/14射程：600");
        skillW.addAttribute("name", "分身");
        skillW.addAttribute("value", "我的影子就足够击败你了");
        Element skillE = legend.addElement("E");
        skillE.setText("劫和他的影分身进行斩击，对附近的敌人造成60/90/120/150/180(+0.8）物理伤害。劫的鬼斩每击中一个敌方英雄，"
                + "都会让【W影奥义！分身】的冷却时间减少2秒。被影分身的鬼斩所击中的敌人，将会被减速20/25/30/35/40%，持续1.5秒。"
                + "被本尊和影分身的两个鬼斩所同时击中的敌人，将会被减速30/37.5/45/52.5/60%，但不会受到额外伤害。消耗：50能量冷却时间：4射程：290");
        skillE.addAttribute("name", "鬼斩");
        skillE.addAttribute("value", "要么拥抱暗影，要么死于黑暗");

        Element skillR = legend.addElement("R");
        skillR.setText("劫变得无法被选取，持续0.75秒，并在原地召唤一个影分身。然后他会冲向目标英雄，并给目标施加死亡印记。"
                + "3秒之后，印记会触发，并且造成物理伤害，伤害值等于（1.0AD）加上劫和他的影分身在印记激活期间所造成的物理伤害和魔法伤害的总和的25/35/45%。"
                + "再次激活【禁奥义！瞬狱影杀阵】，将会让劫与此技能所创造的影分身交换位置。冷却时间：120/100/80射程：625");
        skillR.addAttribute("name", "瞬狱影杀阵");
        skillR.addAttribute("value", "无形之刃，最为致命");

        // 文档树已经建好了，接下来就是写入到XML文件里面去了。
        OutputFormat format = new OutputFormat("  ", true, "UTF-8");
        XMLWriter writer = new XMLWriter(new FileOutputStream("D:"     //创建文件
                + File.separator + "lol.xml"), format);
        writer.write(document);
        writer.close();
    }

    public static void readXML(Element root) {
        //读它，先拿到它解析它
        if (null == root) return;
        System.out.println("获取根元素成功，信息如下：" + root.getName());
        System.out.println(root.attributeValue("id"));
        System.out.println(root.attributeValue("slogan"));
        //获取根元素下的子元素
//		root.element("hero");
        List<Element> list = root.elements();
        for (int i = 0; i < list.size(); i++) {
            Element e = list.get(i);
            System.out.println(e.getName());
            System.out.println(e.attributeValue("name") + "\t" + e.attributeValue("fullName"));
            List<Element> childList = e.elements();
            //ce---childElement
            for (Element ce : childList) {
                System.out.println(ce.getName());
                System.out.println(ce.attributeValue("name"));
                System.out.println(ce.attributeValue("value"));
                System.out.println("元素的内容为：\n" + ce.getData());
                System.out.println();
            }
            System.out.println();

        }

    }

    public static void parseXML(String fileName) throws Exception {
        File file = new File(fileName);
        InputStream in = new FileInputStream(file);
        //读，使用saxreader
        SAXReader reader = new SAXReader();
        Document doc = reader.read(in);
        Element root = doc.getRootElement();
        readXML(root);
    }

}
