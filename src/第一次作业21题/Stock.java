package 第一次作业21题;

/**
 * 股票类
 */
public class Stock {
    private String symbol; //股票代码
    private String name;  //股票名字
    private double previousClosingPrice; //前一天的股票值
    private double currentPrice;  //当前的股票值

    public Stock(String symbol,String name){
        this.symbol=symbol;
        this.name=name;
    }

    //previousClosingPrice变化到currentPrice的百分比
    public double getChangePercent(){
        //保留小数点后两位，并四舍五入
        double changePercent=(currentPrice-previousClosingPrice)/previousClosingPrice*100;
        return (double)Math.round(changePercent*100)/100;
    }

    //设置股票的前一日的股票值
    public void setPreviousClosingPrice(double previousClosingPrice) {
        this.previousClosingPrice = previousClosingPrice;
    }

    //设置当前的股票值
    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }
}
