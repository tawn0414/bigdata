package hdfs.exam;
import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
/*
 * 하둡의 hdfs를 api로 제어하기.
 * 	- hadoop hdfs에 api를 이용해서 파일을 읽기	
 */
public class HDFSExam02 {

	public static void main(String[] args) {
		//1. hdfs를 제어하기 위해서 설정 파일을 읽어서 사용해야 함.
		//	 hadoop 설치 폴더의 설정 파일을 접근하기 위해 제공되는 클래스.
		Configuration conf = new Configuration();
		
		//2. HDFS를 접근하기 위해서 제공되는 객체 생성.
		FileSystem hdfs = null;
		//3. HDFS에 input하기 위한 스트림객체.
		FSDataInputStream hdfsin = null;
		try {
			hdfs = FileSystem.get(conf); //IOExecption뜨니까 try catch해주기.
			
			//4. HDFS의 경로를 표현할 수 있는 객체(Path)
			//	 => HDFS에 출력할 파일의 경로를 명령행매개변수로 받아서 적용하겠다는 의미
			Path path = new Path(args[0]);
			
			//5. HDFS에 저장된 파일을 읽어야 하므로 스트림 생성하기
			hdfsin = hdfs.open(path);
			//6. HDFS에 저장된 데이터를 읽는다.
			System.out.println(hdfsin.readUTF());
		} catch (IOException e) {
			e.printStackTrace();
		}						
	}
}
