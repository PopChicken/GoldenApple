
use pocketmine\item\Item;
use pocketmine\level\Level;
use pocketmine\Player;

class Generic extends Block{

	public function place(Item $item, Block $block, Block $target, $face, $fx, $fy, $fz, Player $player = null){
		return $this->getLevel()->setBlock($this, $this, true, true);
	}

	public function isBreakable(Item $item){
		return $this->breakable;
	}

	public function onBreak(Item $item){
		return $this->getLevel()->setBlock($this, new Air(), true, true);
	}

	public function onUpdate($type){
		return false;
	}

	public function onActivate(Item $item, Player $player = null){
		return $this->isActivable;
	}
}