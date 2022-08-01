package my.edu.tarc.carloan

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import my.edu.tarc.carloan.databinding.FragmentAboutBinding
import my.edu.tarc.carloan.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass.
 * Use the [AboutFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AboutFragment : Fragment() {

    private var _binding: FragmentAboutBinding? = null

    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Enable handling of menu item
        setHasOptionsMenu(true)



    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        _binding = FragmentAboutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val packageManager = context?.packageManager!!
        val version = packageManager.getPackageInfo(context?.packageName!!,
        PackageManager.GET_ACTIVITIES)
        binding.textViewVersion.text = version.versionName.toString()

        binding.textViewTnC.setOnClickListener{
            val intent = Intent(context, TnCActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        super.onPrepareOptionsMenu(menu)
        menu.findItem(R.id.action_about).isVisible = false
        menu.findItem(R.id.action_settings).isVisible = false
    }
}