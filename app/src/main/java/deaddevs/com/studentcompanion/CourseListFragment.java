package deaddevs.com.studentcompanion;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import deaddevs.com.studentcompanion.utils.DatabaseManager;
import deaddevs.com.studentcompanion.utils.FontAwesomeHelper;

public class CourseListFragment extends Fragment {

    CoreActivity core;
    ListView courseList;
    DatabaseManager db;

    public CourseListFragment() {
    }

    @SuppressLint("ValidFragment")
    public CourseListFragment(CoreActivity core) {
        this.core = core;
        db = core.getDB();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_course_list, container, false);
        TextView profile = v.findViewById(R.id.ProfilePic);
        TextView setting = v.findViewById(R.id.SettingPic);
        TextView courselist = v.findViewById(R.id.CourseListPic);
        TextView todoList = v.findViewById(R.id.TodoPic);
        courseList = v.findViewById(R.id.CourseListView);

        setOnClicks();

        profile.setTypeface(FontAwesomeHelper.getTypeface(getContext(), FontAwesomeHelper.FONTAWESOME));
        setting.setTypeface(FontAwesomeHelper.getTypeface(getContext(), FontAwesomeHelper.FONTAWESOME));
        courselist.setTypeface(FontAwesomeHelper.getTypeface(getContext(), FontAwesomeHelper.FONTAWESOME));
        todoList.setTypeface(FontAwesomeHelper.getTypeface(getContext(), FontAwesomeHelper.FONTAWESOME));
        return v;
    }

    public void setOnClicks() {
        courseList.setClickable(true);
        courseList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                Object o = courseList.getItemAtPosition(position);
                String str = (String) o;
                String id = db.getID(str);
                core.navToCoursePage(str, id);
            }
        });
    }
}
