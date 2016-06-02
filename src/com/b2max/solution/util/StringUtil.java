package com.b2max.solution.util;

import java.io.UnsupportedEncodingException;
import java.util.StringTokenizer;

import com.b2max.solution.data.AppProperties;

public class StringUtil
{
	public static boolean hasContain( Object items[], Object item )
	{
		boolean isContain = false;
		for ( Object obj : items )
		{
			if ( obj.toString().equals( item.toString() ) ) 
			{
				isContain = true;
				break;
			}
		}
		
		return isContain;
	}
	
	public static boolean hasNull( String str )
	{
		if ( str == null || str.length() == 0 ) return true;
		return false;
	}
	
	public static String[] getSplitValues( String valueStr, String del )
	{
		String values[] = valueStr.split( del );
		
		return values;
	}
	
	public static String lengthLimit( String inputStr, int limit, String fixStr ) 
	{ 
        if ( inputStr == null ) return "";
        if ( limit <= 0 ) return inputStr;

        byte[] strbyte = null;

        strbyte = inputStr.getBytes();

        if ( strbyte.length <= limit ) return inputStr;

        char[] charArray = inputStr.toCharArray();

        int checkLimit = limit;
        for ( int i = 0 ; i < charArray.length ; i++ ) 
        {
            if ( charArray[i] < 256 )
                checkLimit -= 1;
            else 
                checkLimit -= 2;

            if (checkLimit <= 0)
                break;
        }

        //대상 문자열 마지막 자리가 2바이트의 중간일 경우 제거함
        byte[] newByte = new byte[limit + checkLimit];

        for ( int i = 0 ; i < newByte.length ; i++ ) 
        {
            newByte[i] = strbyte[i];
        }

        if ( fixStr == null ) 
            return new String( newByte );
        else 
            return new String( newByte ) + fixStr;
    }


	public static String[] getDateStrArr( String dateStr )
	{
		StringTokenizer st = new StringTokenizer( dateStr, "." );
		int cnt = st.countTokens();
		String[] dateStrArr = new String[cnt];
		for ( int i=0; i<cnt; i++ )
		{
			dateStrArr[i] = st.nextToken();
		}
		
		return dateStrArr;
	}
	
	public static String[] getNumStr( int length )
	{
		String arr[] = new String[length];
		int num = 0;
		for ( int i=0; i<length; i++ )
		{
			num = i + 1;
			arr[i] = ( num < 10 ) ? "0" + num : "" + num;
		}
		
		return arr;
	}
	
	public static String getISOToUTF( String str )
	{
		String value = "";
		if ( hasNull( str ) ) return value;
		try
		{
			value = new String( str.getBytes( AppProperties.CHAR_ISO ), AppProperties.CHAR_UTF );
		} 
		catch ( UnsupportedEncodingException e )
		{
			e.printStackTrace();
		}
		return value;
	}
	
	public static String getEUCToUTF( String str )
	{
		String value = "";
		if ( hasNull( str ) ) return value;
		try
		{
			System.out.println( str );
			value = new String( str.getBytes( AppProperties.CHAR_SET ), AppProperties.CHAR_UTF );
		} 
		catch ( UnsupportedEncodingException e )
		{
			e.printStackTrace();
		}
		return value;
	}
	
	public static String getUTFToEUC( String str )
	{
		String value = "";
		if ( hasNull( str ) ) return value;
		try
		{
			value = new String( str.getBytes( AppProperties.CHAR_UTF ), AppProperties.CHAR_SET );
		} 
		catch ( UnsupportedEncodingException e )
		{
			e.printStackTrace();
		}
		return value;
	}
	
	public static String getRandomString()
	{
		String randStr = "";
//		// 숫자를 제외한 길이 32의 랜덤 문자열 생성.
//		randStr =  new RandomStringBuilder().
//		           putExcludedChar(RandomStringBuilder.NUMBER).
//		           setLength(32).build();
		     
		// 알파벳으로 이루어진 길의 32의 랜덤 문자열 생성.
		randStr =  new RandomStringBuilder().
		           putLimitedChar(RandomStringBuilder.ALPHABET).
		           setLength(32).build();
		     
//		// 대문자와 특수문자로 이루어져있고, ?.,&$/\"' 를 제외한 길이 32의 랜덤 문자열 생성. 
//		randStr =  new RandomStringBuilder().
//		           putLimitedChar(RandomStringBuilder.ALPHABET_UPPER_CASE).
//		           putLimitedChar(RandomStringBuilder.SPECIAL).
//		           putExcludedChar("?.,&$/\\\"'").
//		           setLength(32).build();
		
		System.out.println(randStr);
		return randStr;
	}
}
