package eniso.ia2.musicbraille

import android.graphics.Color
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import eniso.ia2.musicbraille.databinding.ActivityMainBinding
import eniso.ia2.musicbraille.databinding.ActivityMusicBinding

class MusicActivity : AppCompatActivity() {
    lateinit var spinner: Spinner
    lateinit var binding: ActivityMusicBinding
   var mMediaPlayer : MediaPlayer?=null
    val notes= mutableListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_music)
        val binding= ActivityMusicBinding.inflate(layoutInflater)
        setContentView(binding.root)
       spinner=findViewById(R.id.spinner)
       val adapter= ArrayAdapter(this, android.R.layout.simple_spinner_item, notes)
       adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter=adapter

      //mediaPlayer = MediaPlayer.create(this, R.raw.audio1)

        binding.btn1.setOnClickListener {
            // val newItem= "DO"        //si on veut un bouton a un mot et l'affiche dans la liste
            //  notes.add(newItem)
            //adapter.notifyDataSetChanged()
            playSound(R.raw.audio1)
           selectedButtons.add(binding.btn1)
        selectedButtons1.add(binding.btn1)
          selectedButtons2.add(binding.btn1)
            selectedButtons3.add(binding.btn1)
            selectedButtons4.add(binding.btn1)
            adapter.notifyDataSetChanged()
        }

        binding.btn4.setOnClickListener {
            playSound(R.raw.audio4)
          selectedButtons.add(binding.btn4)
      selectedButtons2.add(binding.btn4)
            selectedButtons3.add(binding.btn4)
            selectedButtons5.add(binding.btn4)
            selectedButtons6.add(binding.btn4)
            adapter.notifyDataSetChanged()

        }


        binding.btn5.setOnClickListener {
            playSound(R.raw.audio5)
            selectedButtons.add(binding.btn5)
        selectedButtons1.add(binding.btn5)
            selectedButtons3.add(binding.btn5)
            selectedButtons4.add(binding.btn5)
            selectedButtons6.add(binding.btn5)
           adapter.notifyDataSetChanged()

        }

        binding.btn2.setOnClickListener {
            playSound(R.raw.audio2)
           selectedButtons2.add(binding.btn2)
            selectedButtons3.add(binding.btn2)
            selectedButtons4.add(binding.btn2)
            selectedButtons5.add(binding.btn2)
            selectedButtons6.add(binding.btn2)
          adapter.notifyDataSetChanged()
        }

        binding.btn3.setOnClickListener {
            playSound(R.raw.audio3)
        }

        binding.btn6.setOnClickListener {
            playSound(R.raw.audio6)
        }

        binding.btnvalider.setOnClickListener {
            checkSelectedButtons()
            playSound(R.raw.narration)
        }

        binding.btnclearnote.setOnClickListener {
            playSound(R.raw.supprimer)
            notes.clear()
        }
    }
   val selectedButtons= mutableSetOf<Button>()
   val selectedButtons1= mutableSetOf<Button>()
    val selectedButtons2= mutableSetOf<Button>()
    val selectedButtons3= mutableSetOf<Button>()
    val selectedButtons4= mutableSetOf<Button>()
    val selectedButtons5= mutableSetOf<Button>()
    val selectedButtons6= mutableSetOf<Button>()

    fun checkSelectedButtons() {
        if(selectedButtons3.size == 4){
            val information = "FA"
            notes.add(information)
            selectedButtons.clear()
            selectedButtons1.clear()
            selectedButtons2.clear()
            selectedButtons3.clear()
            selectedButtons4.clear()
            selectedButtons5.clear()
            selectedButtons6.clear()
        }
          else  if (selectedButtons.size == 3){
       // if((selectedButtons.contains(binding.btn1))&&(selectedButtons.contains(binding.btn4))&&(selectedButtons.contains(binding.btn5))){
                val information = "DO"
                notes.add(information)
                selectedButtons.clear()
                selectedButtons1.clear()
                selectedButtons2.clear()
                selectedButtons3.clear()
            selectedButtons4.clear()
            selectedButtons5.clear()
            selectedButtons6.clear()
            }



         else if(selectedButtons2.size == 3){
                val information = "MI"
                notes.add(information)
             selectedButtons.clear()
             selectedButtons1.clear()
             selectedButtons2.clear()
                selectedButtons3.clear()
            selectedButtons4.clear()
            selectedButtons5.clear()
            selectedButtons6.clear()
        }
        else if(selectedButtons4.size == 3){
            val information = "SOL"
            notes.add(information)
            selectedButtons.clear()
            selectedButtons1.clear()
            selectedButtons2.clear()
            selectedButtons3.clear()
            selectedButtons4.clear()
            selectedButtons5.clear()
            selectedButtons6.clear()
        }
        else if(selectedButtons6.size == 3){
            val information = "SI"
            notes.add(information)
            selectedButtons.clear()
            selectedButtons1.clear()
            selectedButtons2.clear()
            selectedButtons3.clear()
            selectedButtons4.clear()
            selectedButtons5.clear()
            selectedButtons6.clear()
        }
        else if (selectedButtons1.size == 2){
            val information = "RE"
            notes.add(information)
            selectedButtons.clear()
            selectedButtons1.clear()
            selectedButtons2.clear()
            selectedButtons3.clear()
            selectedButtons4.clear()
            selectedButtons5.clear()
            selectedButtons6.clear()
        }
        else if (selectedButtons5.size == 2){
            val information = "LA"
            notes.add(information)
            selectedButtons.clear()
            selectedButtons1.clear()
            selectedButtons2.clear()
            selectedButtons3.clear()
            selectedButtons4.clear()
            selectedButtons5.clear()
            selectedButtons6.clear()
        }



    }
    private fun playSound(soundResId: Int) {
        if (mMediaPlayer != null && mMediaPlayer?.isPlaying == true) {
            //Stops playback
            mMediaPlayer?.stop()
            mMediaPlayer?.release()
            mMediaPlayer = null
            playSound(soundResId)
        } else {
            // Plays the number sound
            mMediaPlayer = MediaPlayer.create(this, soundResId)
            mMediaPlayer?.start()

        }
    }

    //  Destroys the MediaPlayer instance when the app is paused / destroyed
    override fun onStop() {
        super.onStop()
        if (mMediaPlayer != null) {
            mMediaPlayer!!.release()
            mMediaPlayer = null
        }
    }



}