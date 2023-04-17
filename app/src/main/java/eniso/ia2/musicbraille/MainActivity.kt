package eniso.ia2.musicbraille

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import eniso.ia2.musicbraille.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var MediaPlayer1 : MediaPlayer?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        val binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnlog.setOnClickListener {
            playSound(R.raw.go)
            val intent = Intent(this, MusicActivity::class.java)
            startActivity((intent))
        }

    }

    private fun playSound(soundResId: Int) {
        if (MediaPlayer1 != null && MediaPlayer1?.isPlaying == true) {
            //Stops playback
            MediaPlayer1?.stop()
            MediaPlayer1?.release()
            MediaPlayer1 = null
            playSound(soundResId)
        } else {
            // Plays the number sound
            MediaPlayer1 = MediaPlayer.create(this, soundResId)
            MediaPlayer1?.start()

        }
    }
    override fun onStop() {
        super.onStop()
        if (MediaPlayer1 != null) {
            MediaPlayer1!!.release()
            MediaPlayer1 = null
        }
    }
}