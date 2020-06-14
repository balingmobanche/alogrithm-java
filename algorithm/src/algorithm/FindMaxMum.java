package algorithm;
/**
 * @author 13297
 * @apiNoted ���η����������������
 *  * */
public class FindMaxMum {
	//���������Ϳ�Խ�����������ⷽ��
	public int[] FINDMAXCROSSINGSUBARRAY(int[] A ,int low, int mid,int high){
		int sum=0;//��¼���������ĺ�
		int maxleft=0;
		int maxright=0;
		int leftsum=Integer.MIN_VALUE;//��¼�������������
		for (int i = mid; i>= low; i--) {
			sum+=A[i];
			if (sum>leftsum) {
				leftsum=sum;//����Ϊ��ǰ���ֵ
				maxleft=i;//��¼��ǰ���ֵ�±�
			}	
		}
		sum=0;
		int rightsum=0;//��¼�ұ�����������
		for (int i = mid+1; i <=high; i++) {
			sum+=A[i];
			if(sum>rightsum) {
				rightsum=sum;//����Ϊ��ǰ���ֵ
				maxright=i;//��¼��ǰ���ֵ�±�
			}	
		}
	    int[] returnarr= new int[3];
		returnarr[0]=maxleft;//������������߽��±�
		returnarr[1]=maxright;//�����������ұ߽��±�
		returnarr[2]=leftsum+rightsum;//����������ֵ
		return returnarr;
		
	}
	public int[] FINDMAXMUMSUBARRAY(int[] A,int low,int high) {
		
		//����ֻ��һ�����ݵ�ʱ��
		if(high==low) {
			int[] ra=new int[3];//���ؽ��
			ra[0]=low;
			ra[1]=high;
			ra[2]=A[low];
			return ra;
		}else {
			int mid=(low+high)/2;
			int[] leftarr=new int[3];//���ؽ��
			int[] rightarr=new int[3];//���ؽ��
			int[] crossarr=new int[3];//���ؽ��

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
