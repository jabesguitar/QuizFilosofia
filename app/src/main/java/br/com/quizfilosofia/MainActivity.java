package br.com.quizfilosofia;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.graphics.Color;
import android.util.Log;

public class MainActivity extends Activity {
    private static final String TAG = "QuizFilosofia";
    private WebView webView;

    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(Color.rgb(30,32,36));
        getWindow().setNavigationBarColor(Color.rgb(24,25,29));
        getWindow().getDecorView().setSystemUiVisibility(0);

        WebView.setWebContentsDebuggingEnabled(true);
        webView = new WebView(this);
        webView.setBackgroundColor(Color.rgb(30,32,36));

        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setAllowFileAccess(true);
        settings.setAllowContentAccess(true);
        settings.setAllowFileAccessFromFileURLs(true);
        settings.setLoadsImagesAutomatically(true);
        settings.setBlockNetworkImage(false);
        settings.setDefaultTextEncodingName("UTF-8");
        settings.setMediaPlaybackRequiresUserGesture(false);
        settings.setSupportZoom(false);
        settings.setBuiltInZoomControls(false);

        webView.setWebViewClient(new WebViewClient() {
            @Override public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
                if (request.isForMainFrame()) {
                    Log.e(TAG, "Falha ao abrir o aplicativo: " + error.getDescription());
                }
            }
        });
        webView.setWebChromeClient(new WebChromeClient() {
            @Override public boolean onConsoleMessage(ConsoleMessage message) {
                Log.d(TAG, "JS " + message.message() + " (" + message.lineNumber() + ")");
                return true;
            }
        });

        setContentView(webView);
        if (savedInstanceState == null) {
            webView.loadUrl("file:///android_asset/index.html");
        } else {
            webView.restoreState(savedInstanceState);
            if (webView.getUrl() == null) webView.loadUrl("file:///android_asset/index.html");
        }
    }

    @Override protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (webView != null) webView.saveState(outState);
    }

    @Override public void onBackPressed() {
        if (webView != null && webView.canGoBack()) webView.goBack();
        else super.onBackPressed();
    }

    @Override protected void onDestroy() {
        if (webView != null) {
            webView.stopLoading();
            webView.destroy();
            webView = null;
        }
        super.onDestroy();
    }
}
