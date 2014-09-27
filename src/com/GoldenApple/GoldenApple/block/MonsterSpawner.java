
namespace pocketmine\block;

use pocketmine\item\Item;

class MonsterSpawner extends Solid{
	public function __construct(){
		parent::__construct(self::MONSTER_SPAWNER, 0, "Monster Spawner");
		$this->hardness = 25;
	}

    public function getBreakTime(Item $item){
        switch($item->isPickaxe()){
            case 5:
                return 0.95;
            case 4:
                return 1.25;
            case 3:
                return 1.9;
            case 2:
                return 0.65;
            case 1:
                return 3.75;
            default:
                return 25;
        }
    }

    public function getDrops(Item $item){
        return [];
    }
}