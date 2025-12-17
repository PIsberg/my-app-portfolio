package udacity.isberg.myappportfolio;


import android.graphics.Color;
import android.graphics.PorterDuff;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainGUI {

    private MainActivity mainActivity;

    private Button appButtons[] = new Button[6];

    public MainGUI(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        initGui();
    }

    private void initGui() {
        initButtons();
        Log.d("MainGUI", "initGui()");
    }


    private void initButtons() {
        int resourceID;
        ButtonListener appButtonListener = new ButtonListener();
        for (int buttonID = 1; buttonID < (appButtons.length+1); buttonID++) {

            resourceID = mainActivity.getResources().getIdentifier("appbutton"+ buttonID, "id", mainActivity.getPackageName());
            addButtonComponent(resourceID, appButtonListener);
        }
    }

    public Button addButtonComponent(int componentId, View.OnClickListener buttonListener) {
        Button button = (Button) mainActivity.findViewById(componentId);
        button.setOnClickListener(buttonListener);
        return button;
    }

    class ButtonListener implements View.OnClickListener {

        public void onClick(android.view.View v) {

            String appName = "";
            int id = v.getId();
            if (id == R.id.appbutton1) {
                appName = mainActivity.getString(R.string.appbutton1);
            } else if (id == R.id.appbutton2) {
                appName = mainActivity.getString(R.string.appbutton2);
            } else if (id == R.id.appbutton3) {
                appName = mainActivity.getString(R.string.appbutton3);
            } else if (id == R.id.appbutton4) {
                appName = mainActivity.getString(R.string.appbutton4);
            } else if (id == R.id.appbutton5) {
                appName = mainActivity.getString(R.string.appbutton5);
            } else if (id == R.id.appbutton6) {
                appName = mainActivity.getString(R.string.appbutton6);
            }

            if (!appName.isEmpty()) {
                String toastText = "This button will launch my " + appName + " app!";
                Toast.makeText(mainActivity.getApplicationContext(), toastText, Toast.LENGTH_SHORT).show();
            }
        }
    }
}