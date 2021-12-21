package com.gxjkzw.common.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Kit
{

    public static String md5(String md5)
    {
        try
        {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(md5.getBytes());
            byte b[] = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++)
            {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            return buf.toString().toUpperCase();
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        return null;

    }

    public static void main(String[] args)
    {
        String text = "e10adc3949ba59abbe56e057f20f883e";
        System.out.println(md5(text));
    }
}
