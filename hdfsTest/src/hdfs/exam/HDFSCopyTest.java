package hdfs.exam;
import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
/*
 * hdfs의 파일을 읽어서 새로운 파일을 생성
 * input파일경로, output파일경로를 명령행매개변수로
 * 클래스파일, 실행결과 캡쳐해서 메일전송
 */
public class HDFSCopyTest {

	public static void main(String[] args) {
	
		Configuration conf = new Configuration();
		
		FileSystem hdfs = null;

		FSDataOutputStream hdfsout = null;
		FSDataInputStream hdfsin = null;
		try {
			hdfs = FileSystem.get(conf);
			
			Path pathin = new Path(args[0]);
			Path pathout = new Path(args[1]);
			hdfsin = hdfs.open(pathin); //읽을 파일 경로
			hdfsout = hdfs.create(pathout);	// 생성할 파일 경로				
			hdfsout.writeUTF(hdfsin.readUTF()); //읽을 파일 읽어서 생성할 파일에 쓰기
			
		} catch (IOException e) {
			e.printStackTrace();
		}						
	}
}
