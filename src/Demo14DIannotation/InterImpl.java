package Demo14DIannotation;

import org.springframework.stereotype.Service;

@Service("inter")
public class InterImpl implements Inter{

	@Override
	public void play() {
		System.out.println("play");
		
	}

}
