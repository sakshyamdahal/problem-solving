import java.io.File;

public class DiskInfo {

	/* 
	 * recursively find the total size of a directory
	 * and also print the size of each nested files and directories
	 */
	public static long diskUse(File root)
	{
		long totalSize = root.length();

		if (root.isDirectory())
		{
			for (String child : root.list())
			{
				File nested = new File(root,child);
				totalSize += diskUse(nested);
			}
		}

		System.out.println(totalSize + "\t" + root);
		return totalSize;
	}

	public static void main(String[] args) {
		DiskInfo.diskUse(new File("../../"));

	}
}