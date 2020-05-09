package cn.example.mp.test.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class FileMd5Util {
    private static final Logger logger = LoggerFactory.getLogger(FileMd5Util.class);
    public static final int BYTE_LENGTH = 1024;
    private FileMd5Util() {
    }

    public static String getFileMd5(File file) {
        if (file.exists() && file.isFile()) {
            byte[] buffer = new byte[1024];

            try {
                FileInputStream in = new FileInputStream(file);
                Throwable var4 = null;

                try {
                    MessageDigest digest = MessageDigest.getInstance("MD5");

                    int len;
                    while((len = in.read(buffer, 0, 1024)) != -1) {
                        digest.update(buffer, 0, len);
                    }

                    BigInteger bigInt = new BigInteger(1, digest.digest());
                    String var7 = bigInt.toString(16);
                    return var7;
                } catch (Throwable var19) {
                    var4 = var19;
                    throw var19;
                } finally {
                    if (in != null) {
                        if (var4 != null) {
                            try {
                                in.close();
                            } catch (Throwable var18) {
                                var4.addSuppressed(var18);
                            }
                        } else {
                            in.close();
                        }
                    }

                }
            } catch (FileNotFoundException var21) {
                logger.error("文件找不到", var21);
            } catch (IOException var22) {
                logger.error("IO异常", var22);
            } catch (NoSuchAlgorithmException var23) {
                logger.error("加密出错", var23);
            }

            return null;
        } else {
            return null;
        }
    }

    public static String getFileMd5(byte[] bytes) {
        if (bytes.length == 0) {
            return null;
        } else {
            MessageDigest digest = null;

            try {
                digest = MessageDigest.getInstance("MD5");
                digest.update(bytes, 0, bytes.length);
            } catch (Exception var5) {
                logger.error("生成出错", var5);
            }

            if (digest != null) {
                BigInteger bigInt = new BigInteger(1, digest.digest());
                String md5 = bigInt.toString(16);
                int md5Length = 31;
                return md5.length() == md5Length ? 0 + md5 : md5;
            } else {
                return null;
            }
        }
    }

    public static byte[] fileToByte(File file) {
        byte[] buffer = null;

        try {
            FileInputStream in = new FileInputStream(file);
            Throwable var3 = null;

            try {
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                Throwable var5 = null;

                try {
                    byte[] b = new byte[1024];

                    int n;
                    while((n = in.read(b)) != -1) {
                        bos.write(b, 0, n);
                    }

                    buffer = bos.toByteArray();
                } catch (Throwable var33) {
                    var5 = var33;
                    throw var33;
                } finally {
                    if (bos != null) {
                        if (var5 != null) {
                            try {
                                bos.close();
                            } catch (Throwable var32) {
                                var5.addSuppressed(var32);
                            }
                        } else {
                            bos.close();
                        }
                    }

                }
            } catch (Throwable var35) {
                var3 = var35;
                throw var35;
            } finally {
                if (in != null) {
                    if (var3 != null) {
                        try {
                            in.close();
                        } catch (Throwable var31) {
                            var3.addSuppressed(var31);
                        }
                    } else {
                        in.close();
                    }
                }

            }
        } catch (FileNotFoundException var37) {
            logger.error("生成出错,文件找不到", var37);
        } catch (IOException var38) {
            logger.error("生成出错", var38);
        }

        return buffer;
    }

    public static String getFileMd5(MultipartFile file) {
        byte[] bytes = null;

        try {
            bytes = file.getBytes();
        } catch (IOException var3) {
            logger.error("文件加密出错", var3);
        }

        return bytes != null ? getFileMd5(bytes) : null;
    }

}
