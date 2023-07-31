package utilities;

import org.testng.annotations.DataProvider;

import java.io.IOException;

public class DataProviders {
    @DataProvider
    public Object[][] getAllData()throws IOException
    {
        String path =System.getProperty("user.dir")+".\\Userdata1.xlsx";
        XLUtility xl=new XLUtility(path);
        int rowNum=xl.getRowCount("sheet1");
        int colNum =xl.getCellCount("sheet1",1);
        String[][] apiData =new String[rowNum][colNum];
        for (int i = 1; i <=rowNum ; i++)
        {
            for (int j = 0; j <colNum ; j++)
            {
                apiData[i-1][j]=xl.getCellData("sheet1",i,j);
            }
        }
        return apiData;
    }
    @DataProvider
    public Object[][] getAllDataForPutReq()throws IOException
    {
        String path =System.getProperty("user.dir")+".\\Userdata2.xlsx";
        XLUtility xl=new XLUtility(path);
        int rowNum=xl.getRowCount("sheet1");
        int colNum =xl.getCellCount("sheet1",1);
        String[][] apiData =new String[rowNum][colNum];
        for (int i = 1; i <=rowNum ; i++)
        {
            for (int j = 0; j <colNum ; j++)
            {
                apiData[i-1][j]=xl.getCellData("sheet1",i,j);
            }
        }
        return apiData;
    }
    @DataProvider
        public Object[] getUsername1() throws IOException
    {
        String path =System.getProperty("user.dir")+".\\Userdata1.xlsx";
        XLUtility xl = new XLUtility(path);
        int rowNum=xl.getRowCount("sheet1");
        String[] apiData = new String[rowNum];
        for (int i = 1; i <=rowNum ; i++) {
            apiData[i-1]= xl.getCellData("sheet1",i,1);
        }
        return apiData;
    }
    @DataProvider
    public Object[] getUsername2() throws IOException
    {
        String path =System.getProperty("user.dir")+".\\Userdata2.xlsx";
        XLUtility xl = new XLUtility(path);
        int rowNum=xl.getRowCount("sheet1");
        String[] apiData = new String[rowNum];
        for (int i = 1; i <=rowNum ; i++) {
            apiData[i-1]= xl.getCellData("sheet1",i,2);
        }
        return apiData;
    }

    @DataProvider
    public Object[][] getAllCredentials()throws IOException
    {
        String path =System.getProperty("user.dir")+".\\Credentials.xlsx";
        XLUtility xl=new XLUtility(path);
        int rowNum=xl.getRowCount("sheet1");
        int colNum =xl.getCellCount("sheet1",1);
        String[][] apiData =new String[rowNum][colNum];
        for (int i = 1; i <=rowNum ; i++)
        {
            for (int j = 0; j <colNum ; j++)
            {
                apiData[i-1][j]=xl.getCellData("sheet1",i,j);
            }
        }
        return apiData;
    }
}
