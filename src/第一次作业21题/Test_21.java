package 第一次作业21题;

import java.util.Scanner;

/**
 * 测试类
 */
public class Test_21 {
    public static void main(String[] args){
        String symbol; //股票代码
        String name; //股票名字
        double previousClosingPrice; //前一日的股票值
        double currentPrice;  //当前的股票值

        //初始化股票
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入股票代码：");
        symbol=scanner.next();
        System.out.println("请输入股票名：");
        /*
        //用流的方式输入带空格的字符串
        String name=null;
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        try {
            name = br.readLine();
        }catch (IOException e){
            e.printStackTrace();
        }*/
        scanner.useDelimiter("\n"); //允许使用输入带空格的字符串
        name=scanner.next();
        System.out.println("请输入昨日股票收盘价：");
        previousClosingPrice=scanner.nextDouble();
        System.out.println("请输入当前股票的价格：");
        currentPrice=scanner.nextDouble();

        //测试程序
        Stock stock=new Stock(symbol,name);
        stock.setCurrentPrice(currentPrice);
        stock.setPreviousClosingPrice(previousClosingPrice);
        System.out.println(name+"股票昨日到今日的市值变化为:"+stock.getChangePercent()+"%");
    }
}
