import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
public class WordAnalyzer {
    void toBinnary(String arr){
        String[] ss = arr.split("\\.");
        //浮点型处理a
        if (ss.length == 2){
            int z=0;
            char[] sz=ss[0].toCharArray();
            char[] sx=ss[1].toCharArray();
            for (int i=0;i<sz.length-1;i++){
                z+=(sz[i]-'0')*Math.pow(10,sz.length-i-1);
            }
            String s1=Integer.toBinaryString(z);
            double x=0.0;
            for (int i=0;i<sx.length;i++){
                x+=(sx[i]-'0')/1.0/(Math.pow(10,i+1));
            }
            StringBuffer sb=new StringBuffer("");
            while (x!=0){
                x*=2;
                sb.append((int)x);
                x=x-(int)x;
            }
            System.out.print(s1);
            System.out.print(".");
            System.out.print(sb);
        }
        //整形处理
        else {
            int z=0;
            char[] sz=ss[0].toCharArray();

            for (int i=0;i<sz.length-1;i++){
                z+=(sz[i]-'0')*Math.pow(10,sz.length-i-1);
            }
            String s1=Integer.toBinaryString(z);
            System.out.print(s1);

        }
    }
    private String keyWords[] = {"printf", "void", "main", "int",
            "double", "break", "include", "begin", "end", "if",
            "else", "while", "switch", "struct", "go", "to",
            "switch", "case", "return", "float", "long",
            "typedef", "sizeof", "static"
    };
    private char ch;


    boolean isKey(String str) {
        for (int i = 0; i < keyWords.length; i++) {
            if (keyWords[i].equals(str))
                return true;
        }
        return false;
    }

    boolean isLetter(char letter) {
        if ((letter >= 'a' && letter <= 'z') || (letter >= 'A' && letter <= 'Z'))
            return true;
        else
            return false;
    }


    boolean isDigit(char digit) {
        if (digit >= '0' && digit <= '9')
            return true;
        else
            return false;
    }



    //词法分析
    void analyze(char[] chars) {
        String arr = "";
        for (int i = 0; i < chars.length; i++) {
            ch = chars[i];
            arr = "";
            if (ch == ' ' || ch == '\t' || ch == '\n' || ch == '\r') ;
            else if (isLetter(ch)) {
                while (isLetter(ch) || isDigit(ch)) {
                    arr += ch;
                    ch = chars[++i];
                }
                //指针回退
                i--;
                if (isKey(arr)) {
                    //关键字
                    System.out.println(arr + "\t1" + "\t关键字");
                } else {
                    //标识符
                    System.out.println(arr + "\t2" + "\t标识符");
                }
            } else if (isDigit(ch)) {
                while (isDigit(ch) || (ch == '.' && isDigit(chars[++i]))) {
                    if (ch == '.')
                        i--;
                    arr = arr + ch;
                    ch = chars[++i];
                }
                //属于无符号常数
                toBinnary(arr);
                System.out.println("\t3" + "\t常数");
            } else switch (ch) {
                //运算符
                case '+':
                    System.out.println(ch + "\t4" + "\t运算符");
                    break;
                case '-':
                    System.out.println(ch + "\t4" + "\t运算符");
                    break;
                case '*':
                    System.out.println(ch + "\t4" + "\t运算符");
                    break;
                case '/':
                    System.out.println(ch + "\t4" + "\t运算符");
                    break;
                case '%':
                    System.out.println(ch + "\t4" + "\t运算符");
                    break;
                case '.':
                    System.out.println(ch + "\t4" + "\t运算符");
                    break;
                //分界符
                case '#':
                    System.out.println(ch + "\t5" + "\t分隔符");
                    break;
                case '"':
                    System.out.println(ch + "\t5" + "\t分隔符");
                    break;
                case ',':
                    System.out.println(ch + "\t5" + "\t分隔符");
                    break;
                case '(':
                    System.out.println(ch + "\t5" + "\t分隔符");
                    break;
                case ')':
                    System.out.println(ch + "\t5" + "\t分隔符");
                    break;
                case '[':
                    System.out.println(ch + "\t5" + "\t分隔符");
                    break;
                case ']':
                    System.out.println(ch + "\t5" + "\t分隔符");
                    break;
                case ';':
                    System.out.println(ch + "\t5" + "\t分隔符");
                    break;
                case '{':
                    System.out.println(ch + "\t5" + "\t分隔符");
                    break;
                case '}':
                    System.out.println(ch + "\t5" + "\t分隔符");
                    break;
                //运算符
                case '=': {
                    ch = chars[++i];
                    if (ch == '=') System.out.println("==" + "\t4" + "\t运算符");
                    else {
                        System.out.println("=" + "\t4" + "\t运算符");
                        i--;
                    }
                }
                break;
                case '>': {
                    ch = chars[++i];
                    if (ch == '=') System.out.println(">=" + "\t4" + "\t运算符");
                    else {
                        System.out.println(">" + "\t4" + "\t运算符");
                        i--;
                    }
                }
                break;
                case '<': {
                    ch = chars[++i];
                    if (ch == '=') System.out.println("<=" + "\t4" + "\t运算符");
                    else {
                        System.out.println("<" + "\t4" + "\t运算符");
                        i--;
                    }
                }
                break;
                //无识别
                default:
                    System.out.println(ch + "\t6" + "\t无识别符");
            }
        }
    }

    public static void main(String[] args) throws Exception {
        String filename = "D:\\SpringDemos\\javacode\\src\\1.c";
        File file = new File(filename);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        char buf[] = new char[(int) file.length() + 1];
        //文本如果为空，则可以用空字符让程序输出无识别符
        reader.read(buf);
        reader.close();
        new WordAnalyzer().analyze(buf);

    }
}