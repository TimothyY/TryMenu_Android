package timothyyudi.trymenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, PopupMenu.OnMenuItemClickListener {

    boolean isMenuAdded=false;
    Button btnPopMenu, btnSetting;
    PopupMenu popMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        supportRequestWindowFeature(Window.FEATURE_NO_TITLE); //uncomment this to custom the activity theme
        setContentView(R.layout.activity_main);

        btnPopMenu = (Button) findViewById(R.id.pop);
        btnPopMenu.setOnClickListener(this);
        btnSetting = (Button) findViewById(R.id.sett);
        btnSetting.setOnClickListener(this);

        //PopupMenu is used to give an idea what context menu is. (Actually ContextMenu is a different class)
        popMenu = new PopupMenu(this, btnPopMenu);
        popMenu.getMenu().add(Menu.NONE, 1, Menu.NONE, "Download");
        popMenu.getMenu().add(Menu.NONE, 2, Menu.NONE, "Insert");
        popMenu.setOnMenuItemClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.asdf,menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        if(isMenuAdded==false){ //validation is needed so the menu is not added repeatedly
            menu.add(0,0,0,"Delete");
        }
        isMenuAdded=true;
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.item1){
            Toast.makeText(this, "Item 1 diklik", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.pop)popMenu.show();
        else if (v.getId()==R.id.sett) startActivity(new Intent(this, SettingsActivity.class));
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        if(item.getItemId()==1){
            Toast.makeText(this, "Menu item 1 click", Toast.LENGTH_SHORT).show();
        }else if(item.getItemId()==2){
            Toast.makeText(this, "Menu item 2 click", Toast.LENGTH_SHORT).show();
        }

        return false;
    }
}
