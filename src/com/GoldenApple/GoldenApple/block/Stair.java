
use pocketmine\item\Item;
use pocketmine\math\AxisAlignedBB;
use pocketmine\Player;

class Stair extends Transparent{

	public function __construct($id, $meta = 0, $name = "Unknown"){
		parent::__construct($id, $meta, $name);
		if(($this->meta & 0x04) === 0x04){
			$this->isFullBlock = true;
		}else{
			$this->isFullBlock = false;
		}
		$this->hardness = 30;
	}

	/*
	public function collidesWithBB(AxisAlignedBB $bb, &$list = []){
		$damage = $this->getDamage();
		$j = $damage & 0x03;

		$f = 0;
		$f1 = 0.5;
		$f2 = 0.5;
		$f3 = 1;

		if(($damage & 0x04) > 0){
			$f = 0.5;
			$f1 = 1;
			$f2 = 0;
			$f3 = 0.5;
		}

		if($bb->intersectsWith($bb2 = new AxisAlignedBB(
			$this->x,
			$this->y + $f,
			$this->z,
			$this->x + 1,
			$this->y + $f1,
			$this->z + 1
		))){
			$list[] = $bb2;
		}

		if($j === 0){
			if($bb->intersectsWith($bb2 = new AxisAlignedBB(
				$this->x + 0.5,
				$this->y + $f2,
				$this->z,
				$this->x + 1,
				$this->y + $f3,
				$this->z + 1
			))){
				$list[] = $bb2;
			}
		}elseif($j === 1){
			if($bb->intersectsWith($bb2 = new AxisAlignedBB(
				$this->x,
				$this->y + $f2,
				$this->z,
				$this->x + 0.5,
				$this->y + $f3,
				$this->z + 1
			))){
				$list[] = $bb2;
			}
		}elseif($j === 2){
			if($bb->intersectsWith($bb2 = new AxisAlignedBB(
				$this->x,
				$this->y + $f2,
				$this->z + 0.5,
				$this->x + 1,
				$this->y + $f3,
				$this->z + 1
			))){
				$list[] = $bb2;
			}
		}elseif($j === 3){
			if($bb->intersectsWith($bb2 = new AxisAlignedBB(
				$this->x,
				$this->y + $f2,
				$this->z,
				$this->x + 1,
				$this->y + $f3,
				$this->z + 0.5
			))){
				$list[] = $bb2;
			}
		}
	}
	*/

	public function getBoundingBox(){
		if(($this->getDamage() & 0x04) > 0){
			return new AxisAlignedBB(
				$this->x,
				$this->y + 0.5,
				$this->z,
				$this->x + 1,
				$this->y + 1,
				$this->z + 1
			);
		}else{
			return new AxisAlignedBB(
				$this->x,
				$this->y,
				$this->z,
				$this->x + 1,
				$this->y + 0.5,
				$this->z + 1
			);
		}
	}

	public function place(Item $item, Block $block, Block $target, $face, $fx, $fy, $fz, Player $player = null){
		$faces = [
			0 => 0,
			1 => 2,
			2 => 1,
			3 => 3,
		];
		$this->meta = $faces[$player->getDirection()] & 0x03;
		if(($fy > 0.5 and $face !== 1) or $face === 0){
			$this->meta |= 0x04; //Upside-down stairs
		}
		$this->getLevel()->setBlock($block, $this, true, true);

		return true;
	}

	public function getDrops(Item $item){
		if($item->isPickaxe() >= 1){
			return [
				[$this->id, 0, 1],
			];
		}else{
			return [];
		}
	}
}