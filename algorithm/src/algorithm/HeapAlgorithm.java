package algorithm;

import java.util.Arrays;
/**
 * @author 13297
 * @apiNote 堆排序算法，这里是最大堆为例，数组中A[0]记录是当前堆的大小，
 * 数组数据是从下表1开始的
 * **/
public class HeapAlgorithm {
	//维护一个堆性质的方法
	public void MaxHeapify(int[] A,int i) {
		int l=2*i;
		int r=2*i+1;
		int largest=0;
		if(l<=A[0]&&A[l]>A[i]){
			largest=l;
		}else {
			largest=i;
		}
		if(r<=A[0]&&A[r]>A[largest]) {
			largest=r;
		}
		if(largest!=i) {
			int temp=A[i];
			A[i]=A[largest];
			A[largest]=temp;
			MaxHeapify(A, largest);
		}
	}
	//建堆
	public void BuildMaxHeap(int[] A){
		int heapSize=A.length-1;
		A[0]=heapSize;
		for(int i=heapSize/2;i>=1;i--) {
			MaxHeapify(A,i);
		}
		System.out.println(Arrays.toString(A));
	}
	//堆排序算法
	public void HeapSort(int[] A) {
		BuildMaxHeap(A);
		for (int i = A.length-1; i >= 2; i--) {
			System.out.print(A[1]+",");
			int temp=A[i];
			A[i]=A[1];
			A[1]=temp;
			A[0]=A[0]-1;
			MaxHeapify(A, 1);
		}
	}
	//测试
	public static void main(String[] args) {
		int[] testarr=new int[] {0,-3,-25,20,-3,-16,-23,18,20,-7,12,-5,-22,15,-4,7};
		HeapAlgorithm heapAlgorithm=new HeapAlgorithm();
		heapAlgorithm.HeapSort(testarr);
	}
}
