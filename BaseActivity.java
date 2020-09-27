public abstract class BaseActivity extends AppCompatActivity {

    public static final String TAG = BaseActivity.class.getSimpleName();
    protected ProgressBar mProgressBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addProgressBar();
    }

    private void addProgressBar() {

        ViewGroup layout = (ViewGroup) findViewById(android.R.id.content).getRootView();

        RelativeLayout relativeLayout = new RelativeLayout(this);
        relativeLayout.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);
        relativeLayout.addView(mProgressBar = new ProgressBar(this, null, android.R.attr.progressBarStyleInverse));

        RelativeLayout.LayoutParams relativelayoutParams =
                new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);

        layout.addView(relativeLayout, relativelayoutParams);

    }

    protected void showLoading(boolean visibility) {
        mProgressBar.setVisibility(visibility ? View.VISIBLE : View.INVISIBLE);
    }

    public abstract void initiliazeViews();

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    public void startActivity(Context context, Class<? extends AppCompatActivity> targetActivity) {
        Intent intent = new Intent(this, targetActivity);
        startActivity(intent);
    }

    public void startActivity(Context context, Class<? extends AppCompatActivity> targetActivity, Bundle bundle) {
        Intent intent = new Intent(this, targetActivity);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void startActivity(Context context, Class<? extends AppCompatActivity> targetActivity, int flag) {
        Intent intent = new Intent(this, targetActivity);
        intent.setFlags(flag);
        startActivity(intent);
    }
}