package algorithm;
/**
 * @author 13297
 * @apiNoted 分治法求解最大子数组求解
 *  * */
public class FindMaxMum {
	//最大子数组和跨越左右数组的求解方法
	public int[] FINDMAXCROSSINGSUBARRAY(int[] A ,int low, int mid,int high){
		int sum=0;//记录最大子数组的和
		int maxleft=0;
		int maxright=0;
		int leftsum=Integer.MIN_VALUE;//记录左边子数组最大和
		for (int i = mid; i>= low; i--) {
			sum+=A[i];
			if (sum>leftsum) {
				leftsum=sum;//更新为当前最大值
				maxleft=i;//记录当前最大值下标
			}	
		}
		sum=0;
		int rightsum=0;//记录右边子数组最大和
		for (int i = mid+1; i <=high; i++) {
			sum+=A[i];
			if(sum>rightsum) {
				rightsum=sum;//更新为当前最大值
				maxright=i;//记录当前最大值下标
			}	
		}
	    int[] returnarr= new int[3];
		returnarr[0]=maxleft;//最大子数组的左边界下表
		returnarr[1]=maxright;//最大子数组的右边界下表
		returnarr[2]=leftsum+rightsum;//最大子数组的值
		return returnarr;
		
	}
	public int[] FINDMAXMUMSUBARRAY(int[] A,int low,int high) {
		
		//数组只有一个数据的时候
		if(high==low) {
			int[] ra=new int[3];//返回结果
			ra[0]=low;
			ra[1]=high;
			ra[2]=A[low];
			return ra;
		}else {
			int mid=(low+high)/2;
			int[] leftarr=new int[3];//返回结果
			int[] rightarr=new int[3];//返回结果
			int[] crossarr=new int[3];//返回结果

			leftarr=FINDMAXMUMSUBARRAY(A,low,mid);
			rightarr=FINDMAXMUMSUBARRAY(A,mid+1,high);
			crossarr=FINDMAXCROSSINGSUBARRAY(A,low,mid,high);
			if(leftarr[2]>=rightarr[2]&&rightarr[2]>=crossarr[2]) {
				return leftarr;
			}else if(rightarr[2]>=leftarr[2]&&leftarr[2]>=crossarr[2]) {
				return rightarr;
			}else {
				return crossarr;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] testarr=new int[] {13,-3,-25,20,-3,-16,-23,18,20,-7,12,-5,-22,15,-4,7};
		FindMaxMum testob=new FindMaxMum();
		int [] result=testob.FINDMAXMUMSUBARRAY(testarr,0,testarr.length-1);
		System.out.println(testarr[result[0]]);
		System.out.println(testarr[result[1]]);
		System.out.println(result[2]);
	}
}
