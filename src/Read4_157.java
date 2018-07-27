public class Read4_157 {
    /* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

    public class Solution extends Reader4 {
        /**
         * @param buf Destination buffer
         * @param n   Maximum number of characters to read
         * @return    The number of characters read
         * 此题read4会更新传参的值，read需要对buf参数进行更新得到最后的结果
         */
        public int read(char[] buf, int n) {
            //存储read4的读取值
            char[] buffer = new char[4];
            //存储read4的读取个数
            int read =0;
            //已经读了多少个数，达到n时或者文件读完时就完成了任务
            int hasRead = 0;
            while (true){
                read = read4(buffer);
                //若存在文件已超出n的需求范围时，以最小的为准
                int toRead = Math.min(read,n-hasRead);
                //将刚刚读取的buffer存储值buf，hasRead这里很巧妙地作为了坐标
                for (int i=0;i<toRead;i++){
                    buf[hasRead++] = buffer[i];
                }
                //文件已到末尾，此时n还没读满, n>file size
                if (read < 4)
                    return hasRead;
                //刚好完成, n<= file size
                if (hasRead == n)
                    return n;
            }
        }
    }
}
