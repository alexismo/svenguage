package fragments;

import com.alexismorin.linguage.se.sv.R;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class DemoFragment extends Fragment {
	
	Button commentBtn;
	
	public void sendFeedback(){
		Intent send = new Intent(Intent.ACTION_SENDTO);
		String uriText = "mailto:" + Uri.encode("mail@alexismorin.com") + 
		          "?subject=" + Uri.encode("A comment about fran'guage") + 
		          "&body=" + Uri.encode("Here's an idea I had:");
		Uri uri = Uri.parse(uriText);

		send.setData(uri);
		startActivity(Intent.createChooser(send, "Send Comment"));
	}
}
