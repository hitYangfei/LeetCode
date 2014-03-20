

import java.util.Hashtable;
import java.util.Map;




public class MaxPointsonaLine{
	public static void main(String[] argvs){
		
		Point[] points = new Point[3];
		points[0]=new Point(0,0);
		points[1]=new Point(1,0);
		points[2]=new Point(0,0);
		
		System.out.println(maxPoints(points));
	}
	public static int maxPoints(Point[] points) {
		if(points==null||points.length==0)
			return 0;
		if(points.length==1)
			return 1;
		if(points.length==2){
			return 2;
		}
		
		int maxPointNums = 1;
		Map<Float,Integer> tmp = new Hashtable<Float,Integer>();
		for(int i=0;i<points.length-1;i++){
			int duplicateNum=0;
			int currentMaxPointNums=0;
			for(int j=i+1;j<points.length;j++){
				if(points[i].x==points[j].x&&points[i].y==points[j].y){
					duplicateNum++;
					continue;
				}
				else if(points[i].x==points[j].x){
					Integer tmpValue = tmp.get(Float.MAX_VALUE);
					if(tmpValue!=null){
						tmpValue = tmpValue+1;
						if(tmpValue>currentMaxPointNums)
							currentMaxPointNums=tmpValue;
						tmp.put(Float.MAX_VALUE, tmpValue);
					}
					else{
						if(1>currentMaxPointNums)
							currentMaxPointNums = 1;
						tmp.put(Float.MAX_VALUE, 1);
					}
				}
				else{
					float tmpKey = (float) (points[j].y-points[i].y)/(points[j].x-points[i].x);
					if(Float.floatToIntBits(tmpKey)==Float.floatToIntBits(-0.0f))
						tmpKey = 0.0f;
					Integer tmpValue = tmp.get(tmpKey);
					if(tmpValue!=null){
						tmpValue = tmpValue+1;
						if(tmpValue>currentMaxPointNums)
							currentMaxPointNums=tmpValue;
						tmp.put(tmpKey, tmpValue);
					}
					else{
						if(1>currentMaxPointNums)
							currentMaxPointNums = 1;
						tmp.put(tmpKey, 1);
					}
				}
			}
			tmp.clear();
			if(currentMaxPointNums==0){
				if(duplicateNum+1>maxPointNums )
					maxPointNums = duplicateNum+1;
				continue;
			}
			if(currentMaxPointNums+1+duplicateNum>maxPointNums)
				maxPointNums = currentMaxPointNums+1+duplicateNum;
		}
		
		return maxPointNums ;
	}
}
class Point{
	int x;
	int y;
	Point(){x=0;y=0;}
	Point(int a,int b){
		this.x=a;
		this.y=b;
	}
	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
	
}
