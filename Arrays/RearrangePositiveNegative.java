public class RearrangePositiveNegative {

	public static void main(String[] args){
		String str = args[0];
		String spl[] = str.split(" ");
		int a[] = new int[spl.length];
		for(int i=0;i<a.length;i++){
			a[i] = Integer.valueOf(spl[i]);
		}
		
		int i=0;
		int j=0;
		int k=0;
		
		i = incrementI(a, i);
		j = incrementJ(a, j);
		
		printArray(a);
		
		int[] b = new int[a.length];
		while(k!=a.length){
// 			System.out.println("i="+i+",j="+j+",k="+k);
			if(k%2 != 0){
				if(i == a.length){
					b[k++] = a[j++];
					j = incrementJ(a,j);
					continue;
				}
				b[k++] = a[i++];
				i = incrementI(a,i);
			} else {
				if(j == a.length){
					b[k++] = a[i++];
					i = incrementI(a,i);
					continue;
				}
				b[k++] = a[j++];
				j = incrementJ(a,j);
			}
		}
		
		printArray(b);
	}
	
	private static int incrementJ(int[] a,int j){
		while(j<a.length && a[j]>=0){
			j++;
		}
		return j;
	}
	
	private static int incrementI(int[] a,int i){
		while(i<a.length && a[i]<=0){
			i++;
		}
		return i;
	}
	
	private static void printArray(int[] a){
		for(Integer x: a){
			System.out.print(x+" ");
		}
		System.out.println();
	}

}