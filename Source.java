import java.util.*;
import java.io.*;

class Source
{
// pair class
static class pair{
	String name;
	String size;
}
/*public static int getLines(String file)
{
	int count = 0;
	LineNumerReader reader = null;
	try{
		reader = new LineNumberReader(new FileReader(new File(file)));
		while((reader.readLine()) != null);
		count = reader.getLineNumber();
	}
	catch(Exception e)
	{
		ex.printStackTrace();
	}
	finally{
		if(reader != null){
		try{ reader.close();
		return count;
		}
		catch(IOException e){ e.printStackTrace();}
		}
	}
}*/
public static void main(String args[]) throws FileNotFoundException
{
	String source;
	String destination;
	Scanner input = new Scanner(System.in);
	source = input.nextLine();
	destination = input.nextLine();
	/**/
	ArrayList<pair> src = new ArrayList<pair>();
	ArrayList<pair> dest = new ArrayList<pair>();
	
	try{
// store source in list
	Scanner sc  = new Scanner(new File(source));
	while(sc.hasNext()){
		pair p = new pair();
		p.name = sc.next();
		p.size = sc.next();
		src.add(p);
	}

//store destination in list
	sc = new Scanner(new File(destination));
	while(sc.hasNext()){
		pair p = new pair();
		p.name = sc.next();
		p.size = sc.next();
		dest.add(p);
		}
	}
	catch(Exception e){
	e.printStackTrace();
	}
/*	for(int i = 0; i < src.size(); i++)
		System.out.println(src.get(i).name + src.get(i).size);
	
	for(int i = 0; i < dest.size(); i++)
		System.out.println(dest.get(i).name + dest.get(i).size);
*/
	
//dp
	int dp[][] = new int[src.size() + 1][dest.size() + 1];
	int lcs = longestCommonSubsequence(src, dest, dp);
	int common[] = longestCommonSubsequence_index(src, dest, dp, lcs);

//common pointer
	int cp = 0;
//dest pointer
	int d = 0;
	if(common.length == 0){
		for(pair p: src)
		{
			System.out.println(p.name + " of size " + p.size + " is missing");	
		}
	}
	while(cp < common.length){
		if(common[cp] != d)
			System.out.println(src.get(d).name + " of size " + src.get(d).size + " is missing");
		else cp++;
		d++;
	}
}

public static boolean Equal(ArrayList<pair> src, ArrayList<pair> dest, int s, int d)
{
	if(src.get(s).name.equals(dest.get(d).name))
	{
		if(src.get(s).size.equals(dest.get(d).size)) return true;
		return false;
	}
	return false;
}
public static int longestCommonSubsequence(ArrayList<pair> src, ArrayList<pair> dest, int dp[][])
{
	for(int i = 0; i <= src.size(); i++)
	{
		for(int j = 0; j <= dest.size(); j++) 
		{
			if(i == 0)
			{
				dp[i][j] = 0;
				continue;
			}
			if(j == 0)
			{
				dp[i][j] = 0;
				continue;
			} 
			if(Equal(src, dest, i-1, j-1)) dp[i][j] = dp[i-1][j-1] + 1;
			else dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
		}
	}
	return dp[src.size()][dest.size()];	
}
public static int[] longestCommonSubsequence_index(ArrayList<pair> src, ArrayList<pair> dest, int dp[][], int lcs)
{
	int common[] = new int[lcs];
	int i = src.size();
	int j = dest.size();
	while(i > 0 && j > 0)
	{
		if(Equal(src, dest, i-1, j-1))
		{
			common[--lcs] = i-1;
			i--;
			j--;
		}
		else
		{
			if(dp[i-1][j] > dp[i][j-1]){
				i--;
			}
			else j--;
		}
	}
	return common;
}

}