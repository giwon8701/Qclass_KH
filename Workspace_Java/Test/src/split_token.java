import java.util.StringTokenizer;

public class split_token {

	public static void main(String[] args) {

		String[] split_word = new String[2];
		String[] res = new String[5];
		String[] res_token = new String[5];

		String colors = "red/yellow#green blue,orange";
		StringTokenizer st = new StringTokenizer(colors, "/#, ");

		/*********************** String ****************************************/
		split_word = colors.split("/"); // split_word[0] = red , split_word[1] = yellow#green blue,orange
		res[0] = split_word[0]; // res[0] = red

		colors = split_word[1]; // colors = yellow#green blue,orange
		split_word = colors.split("#"); // split_word[0] = yellow , split_word[1] = green blue,orange
		res[1] = split_word[0]; // res[1] = yellow

		colors = split_word[1]; // colors = green blue,orange
		split_word = colors.split(" "); // split_word[0] = green , split_word[1] = blue,orange
		res[2] = split_word[0]; // res[2] = green

		colors = split_word[1]; // colors = blue,orange
		split_word = colors.split(","); // split_word[0] = blue , split_word[1] = orange
		res[3] = split_word[0]; // res[3] = blue
		res[4] = split_word[1]; // res[4] = orange

		System.out.println("String 출력");
		for (String s : res) {
			System.out.println(s);
		}
		/*************************************************************************/

		System.out.println("----------------------");
		/************************ StringTokenizer****************************************/
/*		split_word[0] = st.nextToken("/");
		res_token[0] = split_word[0];

		split_word[0] = st.nextToken("#");
		res_token[1] = split_word[0];

		split_word[0] = st.nextToken(" ");
		res_token[2] = split_word[0];

		split_word[0] = st.nextToken(",");
		res_token[3] = split_word[0];

		split_word[1] = st.nextToken();
		res_token[4] = split_word[1];
*/
		System.out.println("StringTokenizer 출력");
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}

	}

}