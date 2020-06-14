package algorithm;

import java.util.Arrays;

/**
 * @author 13297
 * @apiNote ��������
 * */
public class QuickAlgorithm {
	//����ѡ��õ���Ԫ�ؽ��л���
	public int  Parttion(int[] A,int p,int r){
		int x=A[r];//ѡ����Ԫ�أ���������ģ�����Ĭ��ѡ�����
		int i=p-1;
		for (int j = p; j < r; j++) {
			if(A[j]<=x) {
				i=i+1;
				int temp=A[i];
				A[i]=A[j];
				A[j]=temp;
			}
		}
		int temp=A[i+1];
		A[i+1]=A[r];
		A[r]=temp;
		return i+1;
	}
	//�ݹ���ÿ��������㷨
	public void QuickSort(int[] A,int p,int r) {
		if(p<r) {
			int q=Parttion(A, p, r);
			QuickSort(A, p, q-1);
			QuickSort(A, p+1, r);
		}
	}
	//��Ԫ�����ѡ��
	public static void main(String[] args) {
		int[] testarr=new int[] {0,-3,-25,20,-3,-16,-23,18,20,-7,12,-5,-22,15,-4,7};
		QuickAlgorithm quickAlgorithm=new QuickAlgorithm();
		quickAlgorithm.QuickSort(testarr,0,testarr.length-1);
		System.out.println(Arrays.toString(testarr));
	}
}
