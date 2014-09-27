
use pocketmine\item\Item;
use pocketmine\math\AxisAlignedBB;
use pocketmine\Player;

class Slab extends Transparent{
	public function __construct($meta = 0){
		parent::__construct(self::SLAB, $meta, "Slab");
		$names = [
			0 => "Stone",
			1 => "Sandstone",
			2 => "Wooden",
			3 => "Cobblestone",
			4 => "Brick",
			5 => "Stone Brick",
			6 => "Quartz",
			7 => "",
		];
		$this->name = (($this->meta & 0x08) === 0x08 ? "Upper " : "") . $names[$this->meta & 0x07] . " Slab";
		if(($this->meta & 0x08) === 0x08){
			$this->isFullBlock = true;
		}else{
			$this->isFullBlock = false;
		}
		$this->hardness = 30;
	}

	public function getBoundingBox(){
		if(($this->meta & 0x08) > 0){
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
		$this->meta &= 0x07;
		if($face === 0){
			if($target->getID() === self::SLAB and ($target->getDamage() & 0x08) === 0x08 and ($target->getDamage() & 0x07) === ($this->meta & 0x07)){
				$this->getLevel()->setBlock($target, Block::get(Item::DOUBLE_SLAB, $this->meta), true);

				return true;
			}elseif($block->getID() === self::SLAB and ($block->getDamage() & 0x07) === ($this->meta & 0x07)){
				$this->getLevel()->setBlock($block, Block::get(Item::DOUBLE_SLAB, $this->meta), true);

				return true;
			}else{
				$this->meta |= 0x08;
			}
		}elseif($face === 1){
			if($target->getID() === self::SLAB and ($target->getDamage() & 0x08) === 0 and ($target->getDamage() & 0x07) === ($this->meta & 0x07)){
				$this->getLevel()->setBlock($target, Block::get(Item::DOUBLE_SLAB, $this->meta), true);

				return true;
			}elseif($block->getID() === self::SLAB and ($block->getDamage() & 0x07) === ($this->meta & 0x07)){
				$this->getLevel()->setBlock($block, Block::get(Item::DOUBLE_SLAB, $this->meta), true);

				return true;
			}
			//TODO: check for collision
		}else{
			if($block->getID() === self::SLAB){
				if(($block->getDamage() & 0x07) === ($this->meta & 0x07)){
					$this->getLevel()->setBlock($block, Block::get(Item::DOUBLE_SLAB, $this->meta), true);

					return true;
				}

				return false;
			}else{
				if($fy > 0.5){
					$this->meta |= 0x08;
				}
			}
		}

		if($block->getID() === self::SLAB and ($target->getDamage() & 0x07) !== ($this->meta & 0x07)){
			return false;
		}
		$this->getLevel()->setBlock($block, $this, true, true);

		return true;
	}

	public function getBreakTime(Item $item){

		switch($item->isPickaxe()){
			case 5:
				return 0.4;
			case 4:
				return 0.5;
			case 3:
				return 0.75;
			case 2:
				return 0.25;
			case 1:
				return 1.5;
			default:
				return 10;
		}
	}

	public function getDrops(Item $item){
		if($item->isPickaxe() >= 1){
			return [
				[$this->id, $this->meta & 0x07, 1],
			];
		}else{
			return [];
		}
	}
}